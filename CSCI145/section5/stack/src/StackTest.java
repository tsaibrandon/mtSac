import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
public class StackTest {

    private final int TEST_VAL = 5;
    Stack stack;

    @Before
    public void setup() {
        stack = new Stack();
    }

    @After
    public void teardown() {
        stack = null;
    }

    @Test
    public void testInitialStackIsEmpty() {
        assertTrue(stack.empty());
    }

    @Test
    public void testStackNotEmptyAfterPush() {
        stack.push(TEST_VAL);

        assertFalse(stack.empty());
    }

    @Test
    public void testStackNotEmptyAfterPushAndPop() {
        stack.push(TEST_VAL);

        stack.pop();

        assertTrue(stack.empty());
    }

    @Test
    public void testPush() {
        stack.push(TEST_VAL);

        assertTrue(stack.peek() == TEST_VAL);
    }

    @Test
    public void testStackOrdering() {
        int i = 1;

        for (; i <= TEST_VAL; i++) 
            stack.push(i);

        --i;

        while(!stack.empty()) {
            assertTrue(i-- == stack.peek());
            stack.pop();
        }
    }

    @Test
    public void testPopOnEmptyStackThrowsEmptyStackException() {
        try {
            stack.pop();
            assertTrue(false);
        } catch(EmptyStackException e) {
            assertFalse(false);
        }
    }

    @Test
    public void testPeekOnEmptyStackThrowsEmptyStackException() {
        try {
            stack.peek();
            assertTrue(false);
        } catch(EmptyStackException e) {
            assertFalse(false);
        }
    }

}
