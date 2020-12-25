package homeWork4;

public class MultiFunctionUnit {
    private final Object monitor = new Object();
    private final String print = "Печатаю...";
    private final String scan = "Сканирую...";
    private volatile boolean printNow = false;
    private volatile boolean scanNow = false;
    private int printIncrement = 0;
    private int scanIncrement = 0;

    public void print(boolean isPrint) {
        if (printNow) {
            System.out.println("Устройство уже печатает");
        }
        synchronized (monitor) {
            while (isPrint) {
                try {
                    printNow = true;
                    while (printNow) {
                        System.out.println(print + ++printIncrement + "\n");
                        Thread.sleep(500);
                        if (Thread.interrupted()) {
                            printNow = false;
                            monitor.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scan(boolean isScan) {
        if (scanNow) {
            System.out.println("Устройство уже сканирует");
            return;
        }
        while (isScan) {
            try {
                scanNow = true;
                while (scanNow) {
                    System.out.println(scan + ++scanIncrement + "\n");
                    Thread.sleep(500);
                    if (Thread.interrupted()) {
                        printNow = false;
                        monitor.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
