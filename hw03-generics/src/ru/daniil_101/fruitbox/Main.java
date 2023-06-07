package ru.daniil_101.fruitbox;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Apple apple1 = new Apple(0.2);
        Apple apple2 = new Apple(0.1);
        Apple apple3 = new Apple(0.15);
        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);

        Box<Orange> orangeBox = new Box<>();
        Orange orange1 = new Orange(0.23);
        Orange orange2 = new Orange(0.15);
        Orange orange3 = new Orange(0.1);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);

        Box<Fruit> fruitBox = new Box<>();
        fruitBox.add(new Apple());
        fruitBox.add(new Apple());
        fruitBox.add(new Apple());
        fruitBox.add(new Orange());
        fruitBox.add(new Orange());

        System.out.println("Коробка с фруктами весит: " + fruitBox.weight() + " кг.");
        System.out.println("Коробка с яблоками весит: " + appleBox.weight() + " кг.");
        System.out.println("Коробка с апельсинами весит: " + orangeBox.weight() + " кг.");
        System.out.println();

        System.out.printf("Коробка с яблоками весит столько же, сколько и с апельсинами? %s \n",
                appleBox.compare(orangeBox) ? "Да" : "Нет");
        System.out.printf("Коробка с фруктами весит столько же, сколько и с яблоками? %s \n",
                fruitBox.compare(appleBox) ? "Да" : "Нет");
        System.out.println();

        if (appleBox.pourInto(fruitBox)){
            System.out.printf("""
                Пересыпали яблоки в коробку с фруктами:\s
                Вес корбки с яблоками: %s кг.\s
                Вес корбки с фруктами: %s кг.\s
                """, appleBox.weight(), fruitBox.weight());
        }
        System.out.println();
    }
}