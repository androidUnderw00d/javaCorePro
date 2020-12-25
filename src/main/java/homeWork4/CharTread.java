package homeWork4;

public class CharTread {
    private final Object process = new Object();
    private volatile char currentLetter = 'A';

    public void outA() {
        synchronized (process) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        process.wait();
                    }
                    System.out.print('A');
                    currentLetter = 'B';
                    process.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void outB() {
        synchronized (process) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        process.wait();
                    }
                    System.out.print('B');
                    currentLetter = 'C';
                    process.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void outC() {
        synchronized (process) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        process.wait();
                    }
                    System.out.print('C');
                    currentLetter = 'A';
                    process.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
