package homeWork.FruitBox;

public class Orange <E> extends Fruit implements Comparable {

    public Orange(float weight) {
        super(1.5f);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
