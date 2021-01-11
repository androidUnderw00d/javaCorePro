package homeWork7;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {
        start(Tests.class);
    }

    private static void start(Class classObject) {
        Method[] methods = classObject.getDeclaredMethods();
        try {
            int beforeCount = 0;
            for (Method o : methods) {

                if (o.getAnnotation(BeforeSuite.class) != null) {
                    if (beforeCount == 1) throw new TestException();
                    System.out.println(o);
                    beforeCount++;
                }
            }
            for (int i = 1; i < 11; i++) {
                for (Method o : methods) {
                    if (o.getAnnotation(Test.class) != null) {
                        Test test =
                                o.getAnnotation(Test.class);
                        if (test.value() == i) {
                            System.out.println(o);
                            System.out.println("value: " + test.value());
                        }
                    }
                }
            }
            int afterCount = 0;
            for (Method o : methods) {
                if (o.getAnnotation(AfterSuite.class) != null) {
                    if (afterCount == 1) throw new TestException();
                    System.out.println(o);
                    afterCount++;
                }
            }
        } catch (TestException e) {
            e.printStackTrace();
        }
    }
}
