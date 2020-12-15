package homeWork.FruitBox;

import java.util.ArrayList;

public class TestBox {

    public static void main(String[] args) {
        testBox();
    }

    private static void testBox() {
        var boxApple = new Box<Apple>(3);
        boxApple.add(new Apple(1.0f));
        boxApple.add(new Apple(1.0f));
        boxApple.add(new Apple(1.0f));

        System.out.println("Вес коробки с яблоками " + boxApple.getBoxWeight());

        var boxOrange = new Box<Orange>(3);
        boxOrange.add(new Orange(1.5f));
        boxOrange.add(new Orange(1.5f));
        boxOrange.add(new Orange(1.5f));

        System.out.println("Вес коробки с апельсинами " + boxOrange.getBoxWeight());

        System.out.println(boxApple.compare(boxOrange));

        //пересыпаем фрукты

        var secondBoxOrange = new Box<Orange>(3);

//        boxOrange.dropFruitToOtherBox(boxApple); // ошибка

        System.out.println("Первая коробка с апельсинами до пересыпания : " + boxOrange.toString());
        boxOrange.display();

        boxOrange.dropFruitToOtherBox(secondBoxOrange);

        System.out.println("Пtрвая коробка с апельсинами после : " + boxOrange.toString());
        boxOrange.display();

        System.out.println("Вторая коробка с апельсинами : " + boxOrange.toString());
        secondBoxOrange.display();


    }


}
