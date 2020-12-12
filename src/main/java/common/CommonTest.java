package common;

public class CommonTest {

    public static void main(String[] args) {

        intTest();
    }

    private static void intTest() {
        IntStorage intStorage = new IntStorage(5);

        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        intStorage.display();
        System.out.println("Find 2: " + intStorage.find(2));
        int valueLast = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);
    }
}
