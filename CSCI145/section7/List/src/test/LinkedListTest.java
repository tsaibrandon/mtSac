package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import interfaces.List;
import model.LinkedList;

public class LinkedListTest {

    private  Integer TEST_VALUE = 5;
    private Integer[] testValues = {5, 10, 15};
    private List<Integer> list;

    @Before
    public void setup() {
        list = new LinkedList<>();
    }

    @After
    public void teardown() {
        list = null;
    }

    @Test
    public void testListIsInitialyEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testListIsNotEmptyAfterAdd() {
        list.add(TEST_VALUE);

        assertFalse(list.isEmpty());
    }

    @Test
    public void listFindsAddedItemAtPositionZero() {
        list.add(TEST_VALUE);

        assertEquals(0, list.find(TEST_VALUE));
    }

    @Test
    public void listDoesNotFindsAddedItemNotAdded() {
        list.add(TEST_VALUE);

        assertEquals(-1, list.find(TEST_VALUE+ 1));
    }

    @Test
    public void getEachItemForward() {
        loadItems(list);

        for (int i = 0; i < testValues.length; i++) {
            assertEquals(testValues[i], list.get(i));
        }
    }

    @Test
    public void getEachItemReverse() {
        loadItems(list);

        for (int i = testValues.length - 1; i >= 0; i++) {
            assertEquals(testValues[i], list.get(i));
        }
    }

    @Test
    public void testGetThrowsIndexOutOfBounds() {
        list.add(TEST_VALUE);

        try {
            list.get(1);
            assertTrue(false);
        }catch(IndexOutOfBoundsException e) {
            assertTrue(true);
        }catch(Exception e) {
            assertTrue(false);
        }
    }
    
    @Test
    public void testSet() {
        loadItems(list);
        list.set(1, TEST_VALUE);
        assertEquals(TEST_VALUE, list.get(1));
    }

    @Test
    public void testSetThrowsIndexOutOfBounds() {
        list.add(TEST_VALUE);

        try {
            list.set(1, TEST_VALUE);
            assertTrue(false);
        }catch(IndexOutOfBoundsException e) {
            assertTrue(true);
        }catch(Exception e) {
            assertTrue(false);
        }
    }
    
    private void loadItems(List<Integer> list2) {
        for(Integer integer : testValues)
            list.add(integer);
    }
    
}
