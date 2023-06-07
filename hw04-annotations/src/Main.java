import ru.daniil.framework.TestRunner;

public class Main {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        try {
            testRunner.run(TestClass.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

