package homeWork;


import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

//        ExchangeTest();
    }

    // ДЗ Пунк 1

    private static void ExchangeTest() {
        var stringStorage = new Exchange<String>(3);

        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");

        var intStorage = new Exchange<Integer>(3);

        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        System.out.println("Initial array: ");
        stringStorage.display();

        stringStorage.exchange(2, 0);

        System.out.println("Final array: ");
        stringStorage.display();
    }




}
