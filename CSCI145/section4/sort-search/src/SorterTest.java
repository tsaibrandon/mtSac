import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SorterTest {
    @Test
    public void testBubbleSortWith3ElemArray() {
        int[] a = {8, 1, 20};

        Sorter.bubbleSort(a);

        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] <= a[i + 1]);
        }
    }

    @Test
    public void testBubbleSortWith1ElemArray() {
        int[] a = {8};

        Sorter.bubbleSort(a);

        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] > a[i + 1]);
        }
    }

    @Test
    public void testBubbleSortWithZeroElemArray() {
        int[] a = {};

        Sorter.bubbleSort(a);

        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] > a[i + 1]);
        }
    }

    @Test
    public void testSwap() {
        int[] a = {1, 2};

        Sorter.swap(a, 0, 1);

        assertTrue(a[0] == 2 && a[1] == 1);
    }
}
