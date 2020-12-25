package homeWork4;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        charOut();
//        fileWrite();
        multiFunctionUnit();
    }

    private static void charOut() {
        CharTread ct = new CharTread();
        new Thread(() -> {
            ct.outA();
        }).start();

        new Thread(() -> {
            ct.outB();
        }).start();

        new Thread(() -> {
            ct.outC();
        }).start();

    }

    private static void fileWrite() {
        File file = new File("src/main/resources/lib/fileForWrite.txt");
        WriteToFile writeToFileTread = new WriteToFile(file);
        new Thread(() -> writeToFileTread.outOne()).start();
        new Thread(() -> writeToFileTread.outTwo()).start();
        new Thread(() -> writeToFileTread.outThree()).start();
        new Thread(() -> writeToFileTread.waite()).start();
    }

    private static void multiFunctionUnit() {
        MultiFunctionUnit mfu = new MultiFunctionUnit();
        new Thread(() -> mfu.print(true)).start();

        new Thread(() -> {
           mfu.scan(true);
        }).start();
    }
}
