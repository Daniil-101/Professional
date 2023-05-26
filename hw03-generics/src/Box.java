import java.util.ArrayList;

public class Box<T extends Fruit> implements InfoService {
    private final ArrayList<T> content;

    public Box() {
        this.content = new ArrayList<>();
    }

    public void add(T fruits) {
        content.add(fruits);
    }

    @Override
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


    // 1. Я не понял как победить Java с ее не пониманием какой список чего содержит и что из чего можно пересыпать,
    // а чего нельзя (вылетает "? capture of ?").

    // 2. Так же не понял почему когда я создаю "Box" без указания ее типа в нее можно засовывать все что хочешь
    // и даже смешивать, а также можно из "Box" пересыпать яблоки и апельсины в "Box<Apple>" или "Box<Orange>"

    //Сделал костыль
    public void pourInto(Box<Fruit> box) { // метод который позволяет пересыпать яблоки и апельсны в коробку с фруктами
        box.getContent().addAll(content);
        content.clear();
    }

    public void topUp(Box<T> box) {  // метод который позволяет пересыпать яблоки в коробку с яблоками и аналогично
        // с апельсинами
        box.getContent().addAll(content);
        content.clear();
    }
}
