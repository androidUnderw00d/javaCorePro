package homeWork7;

public class Tests {

    @AfterSuite
    public void afterTest(){
        System.out.println("After test");
    }

    @Test (9)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test (1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test (3)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test (6)
    @AfterSuite
    public void test3(){
        System.out.println("Test 3");
    }

    @BeforeSuite
    public void beforeTest(){
        System.out.println("Before test");
    }
}
