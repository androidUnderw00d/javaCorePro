package homeWork4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private final Object process = new Object();
    private volatile int queueOrder = 1;
    private File file = null;
    private String str = "Многое узнать ты еще можешь, мой старый падаван. Это только начало \n";
    private FileWriter fileWriter;


    public WriteToFile(File file) {
        this.file = file;
    }

    public void outOne() {
        synchronized (process) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueOrder != 1) {
                        process.wait();
                    }
                    fileWriter.write(str);
                    fileWriter.flush();
                    queueOrder = 2;
                    process.notifyAll();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void outTwo() {
        synchronized (process) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueOrder != 2) {
                        process.wait();
                    }
                    fileWriter.write(str);
                    fileWriter.flush();
                    queueOrder = 3;
                    process.notifyAll();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void outThree() {
        synchronized (process) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueOrder != 3) {
                        process.wait();
                    }
                    fileWriter.write(str);
                    fileWriter.flush();
                    queueOrder = 4;
                    process.notifyAll();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void waite() {
        synchronized (process) {
            try {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 10; i++) {
                    while (queueOrder != 4) {
                        process.wait();
                    }
                    Thread.sleep(1000);
                    fileWriter.flush();
                    System.out.println("Пауза записи в файл 1 s");
                    queueOrder = 1;
                    process.notifyAll();
                    System.out.println(System.currentTimeMillis() - start);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
