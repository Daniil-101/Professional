package ru.daniil.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TestRunner {
    public void run(Class<?> clazz) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        System.out.println("Начинаем тестировать класс" + clazz.getName());
        int passedTest = 0;

        List<Method> testMethods = getAnnotatedMethods(clazz, Test.class);
        List<Method> beforeMethods = getAnnotatedMethods(clazz, Before.class);
        List<Method> afterMethods = getAnnotatedMethods(clazz, After.class);

        for (Method m : testMethods) {
            Object instance = clazz.getConstructor().newInstance();
            String errorMessage = null;
            try {
                invokeMethods(instance,beforeMethods);
                m.invoke(instance);
                passedTest++;
            } catch (Exception e) {
                errorMessage = e.getCause().getMessage();
            }finally {
                invokeMethods(instance,afterMethods);
            }

            System.out.printf("Test: %s - %s\n", m.getName(), errorMessage == null ? "PASSED" : "FAIL");
            if(errorMessage != null) System.err.printf("Test: '%s' failed because %s\n", m.getName(), errorMessage);
        }
        System.out.printf("All test: %s, passed: %s, failed: %s\n", testMethods.size(), passedTest, testMethods.size()-passedTest);
    }

    private void invokeMethods(Object instance, List<Method> annotationMethod) {
        for(Method method : annotationMethod){
            try {
                method.invoke(instance);
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new Error(e);
            }
        }
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> annotation){
        List<Method> listMethods = new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(annotation)) listMethods.add(m);
        }
        return listMethods;
    }
}
