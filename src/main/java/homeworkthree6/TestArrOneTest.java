package homeworkthree6;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

public class TestArrOneTest {

    private TestArrOne test1;
    private int[] arr;

    public TestArrOneTest(int[] arr) {
        this.arr = arr;
    }

    @Before
    public void startTest() {
        test1 = new TestArrOne();
    }

    @BeforeEach
    public void init() {
        Assertions.assertNotNull( test1 );
        Assertions.assertNotNull(arr);
    }

    @Test
    public void OneFourArrTest() {
        Assertions.assertTrue( TestArrOne.OneFourArr( new int[]{1, 4, 4, 1, 1, 4, 1, 4, 1} ) );
        Assertions.assertTrue( TestArrOne.OneFourArr( new int[]{4, 1, 4, 1, 4, 4, 1, 4, 4} ) );
        Assertions.assertTrue( TestArrOne.OneFourArr( new int[]{1, 1, 1, 4, 1, 1, 1, 4, 1} ) );
        Assertions.assertFalse( TestArrOne.OneFourArr( new int[]{2, 3, 7, 5, 3, 5, 3, 2, 8} ) );
        Assertions.assertFalse( TestArrOne.OneFourArr( new int[]{4, 1, 4, 1, 8, 4, 1, 4, 4} ) );
        Assertions.assertFalse( TestArrOne.OneFourArr( new int[]{1, 1, 1, 4, 1, 7, 1, 4, 1} ) );
    }

    @Test
    public void ReturnArrAfterTest() {
        Assertions.assertEquals(new int[]{2, 3, 8, 5, 6}, test1.ReturnArrAfter(new int[]{1, 6, 5, 4, 2, 3, 8, 5, 6}));
        Assertions.assertEquals(new int[]{3, 2, 1}, test1.ReturnArrAfter(new int[]{2, 4, 7, 5, 3, 4, 3, 2, 1}));
        Assertions.assertEquals(new int[]{1, 2, 3, 1, 7, 6}, test1.ReturnArrAfter(new int[]{3, 8, 4, 1, 2, 3, 1, 7, 6}));
        Assertions.assertEquals(new int[]{3, 3, 3, 3}, test1.ReturnArrAfter(new int[]{8, 5, 3, 2, 4, 3, 3, 3, 3}));

    }

    @Test
    private Executable ReturnArrAfterTest(int[] arr) {
        Assertions.assertThrows( RuntimeException.class, ReturnArrAfterTest(new int[]{2, 3, 7, 5, 3, 5, 3, 2, 8}));
        Assertions.assertThrows( RuntimeException.class, ReturnArrAfterTest(new int[]{6, 7, 7, 9, 7, 8, 3, 2, 5}));

        int[] arr1 = new int[]{2, 4, 7, 5, 3, 4, 3, 2, 1};
        try {
            test1.ReturnArrAfter(arr1);
        } catch (RuntimeException e) {
            Assertions.fail("Will not trows Exeption");
        }

        int[] arr2 = new int[]{3, 8, 4, 1, 2, 3, 1, 7, 6};
        try {
            test1.ReturnArrAfter(arr2);
        } catch (RuntimeException e) {
            Assertions.fail("Will not trows Exeption");
        }
    }


}