package homeWork;

public class Exchange<T extends Object> {

    private T[] objects;
    private int currentSize;

    public Exchange(int size) {
        this.objects = (T[]) new Object[size];
    }

    public void exchange(int i, int j) {
        T temp = objects[i];
        objects[i] = objects[j];
        objects[j] = temp;
    }


    public void add(T value) {
        add(value, currentSize);
    }

    public void add(T value, int index) {
        objects[index] = value;
        currentSize++;
    }

    public void display() {
        for (T object : objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}
