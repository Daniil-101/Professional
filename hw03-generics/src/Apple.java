import java.util.Random;

public class Apple extends Fruit {
    private final double weight;

    public Apple() {
        this.weight = 0.05 + new Random().nextDouble() * (0.2 - 0.05);
    }

    public Apple(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
