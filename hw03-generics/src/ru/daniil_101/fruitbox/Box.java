package ru.daniil_101.fruitbox;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> content;

    public Box() {
        this.content = new ArrayList<>();
    }

    public void add(T fruits) {
        content.add(fruits);
    }

    public double weight() {
        double result = 0;
        for (T fruit : content) {
            result += fruit.getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.weight() - box.weight()) < 0.1;
    }

    public ArrayList<T> getContent() {
        return content;
    }

    public boolean pourInto(Box<? super T> box) {
        if (box == null || box == this) return false;
        box.getContent().addAll(content);
        content.clear();
        return true;
    }
}
