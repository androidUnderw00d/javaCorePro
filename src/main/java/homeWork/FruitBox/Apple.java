package homeWork.FruitBox;

public class Apple<E> extends Fruit implements Comparable {

    public Apple(float weight) {
        super(1.0f);
    }

    public Apple() {
        super();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
