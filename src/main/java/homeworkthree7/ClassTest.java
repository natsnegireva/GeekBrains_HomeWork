package homeworkthree7;

public class ClassTest {
    @BeforeSuite
    public static void before() {
        System.out.println( "тест до" );
    }

    @Test(priority = 1)
    public static void addTest1() {
        System.out.println( "тест номер 1" );
    }

    @Test(priority = 2)
    public static void addTest2() {
        System.out.println( "тест номер 2" );
    }

    @Test(priority = 3)
    public static void addTest3() {
        System.out.println( "тест номер 3" );
    }

    @Test(priority = 2)
    public static void addTest4() {
        System.out.println( "тест номер 3" );
    }

    @AfterSuite
    public static void after() {
        System.out.println( "тест после" );
    }

}
