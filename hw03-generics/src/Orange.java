import java.util.Random;

public class Orange extends Fruit {
    private final double weight;

    public Orange() {
        this.weight = 0.05 + new Random().nextDouble() * (0.2 - 0.05);
    }

    public Orange(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
