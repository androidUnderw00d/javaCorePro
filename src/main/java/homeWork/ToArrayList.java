package homeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class ToArrayList<E extends Object> {
    private E[] data;
    private int currentSize;


    public ToArrayList(int size) {
        this.data = (E[]) new Object[size];
    }


    public static void main(String[] args) {
        ConvertoList();
    }

    private static void ConvertoList() {

        Integer[] intStorage = {1, 2, 3};
        Double[] doublesStorage = {1.0, 2.0, 3.0};
        String[] stringStorage = {"A", "B", "C"};

//        var stringStorage = new ToArrayList<String>(3);

//        stringStorage.add("A");
//        stringStorage.add("B");
//        stringStorage.add("C");

//        var intStorage = new ToArrayList<Integer>(3);

//        intStorage.add(1);
//        intStorage.add(2);
//        intStorage.add(3);

        arrayToArrayList(stringStorage);
        System.out.println(Arrays.toString(stringStorage));
    }

    public void add(E value) {
        add(value, currentSize);

    }

    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }

    private static <E> ArrayList arrayToArrayList(E[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
