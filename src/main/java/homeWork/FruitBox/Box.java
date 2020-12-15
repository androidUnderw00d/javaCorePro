package homeWork.FruitBox;

import java.util.ArrayList;

public class Box <E extends Fruit & Comparable> {

    private ArrayList<E> box;
    private int currentSize;

    public Box (int size) {
        box = new ArrayList<E>(size);

    }

    public void add(E fruit) {
        box.add(fruit);
        currentSize++;
    }

    public void add(E fruit, int index) {
        box.add(index, fruit);
        currentSize++;
    }

    public float getBoxWeight(){
        float  sumWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            sumWeight = sumWeight + box.get(i).getFruitWeight();
        }
        return sumWeight;
    }



    public boolean compare(Box<? extends Fruit> boxToCompare){
        return Math.abs(getBoxWeight() - boxToCompare.getBoxWeight()) < 0.0001;
    }
    
    public void dropFruitToOtherBox(Box<E> otherBox){
        otherBox.box.addAll(this.box);
        this.box.clear();
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < box.size(); i++) {
            String value = String.valueOf(box.get(i));
            System.out.print(value + " ");
        }
       System.out.println();
        }
}
