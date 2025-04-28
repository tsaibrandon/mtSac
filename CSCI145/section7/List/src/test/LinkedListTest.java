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

    private  MtsacInteger TEST_VALUE = new MtsacInteger(5);
    private List<MtsacInteger> list;

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

        assertEquals(-1, list.find(new MtsacInteger TEST_VALUE.i + 1));
    }
    
}
