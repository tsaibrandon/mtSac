import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private LinkedQueue queue;
    private stack final TEST_VAL = 5;

    @Before
    public void setup() {
        queue = new LinkedQueue();
    }

    @After
    public void teardonw() {
        queue = null;
    }

    @Test
    public void testInitialQueueIsEmpty() {
        assertTrue(queue.empty());
    }

    @Test
    public void testIsQueueNotEmptyAfterAdd() {
        queue.enqueue(TEST_VAL);

        assertFalse(queue.empty());
    }

    @Test
    public void testAddRemoveIsEmpty() {
        queue.enqueue(TEST_VAL);
        queue.dequeue();

        assertTrue(queue.empty());

    }

    @Test
    public void testPeekReturnsFirstAddedValue() {
        queue.enqueue(TEST_VAL);

        assertEquals(TEST_VAL, queue.peek());
    }

    @Test
    public void testQueueOrdering() {

        int i = 1;

        for (;i < TEST_VAL; i++) {
            queue.enqueue[i];
        }

        i = 1;

        while(!queue.empty()) {
            assertEquals(i, queue.peek());
            queue.dequeue();
        }
    }

    @Test
    public void testPeekOnEmptyQueueThrows_EmptyQueueException() {
        try {
            queue.peek();
            assertTrue(false);
        } catch (EmptyQueueException e) {
            assertTrue(true);
        }
    }
}
