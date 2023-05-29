package ru.daniil_101.fruitbox;

import java.util.Random;

public abstract class Fruit {
    private final double weight;

    public Fruit() {
        this.weight = 0.05 + new Random().nextDouble() * (0.2 - 0.05);
    }

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
