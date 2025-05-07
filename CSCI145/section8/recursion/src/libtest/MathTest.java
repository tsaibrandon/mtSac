package libtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.InvalidParameterException;

import org.junit.Test;
import lib.Math;

public class MathTest {
    
    @Test
    public void testFactOfZero() {
        assertEquals(1L, Math.fact(0));
    }

    @Test
    public void testFactOfOne() {
        assertEquals(1L, Math.fact(1));
    }

    @Test
    public void testFactOfTen() {
        assertEquals(55L, Math.fact(10));
    }

    @Test
    public void testFactOfNegativeThrowsEx() {
       try {
        lib.Math.fact(-1);
        assertFalse(true);
       }catch (InvalidParameterException e) {
        assertTrue(true);
       }catch (Exception e) {
        assertFalse(true);
       }

    }

    @Test
    public void testFibOfZero() {
        assertEquals(0L, Math.fib(0));
    }
    @Test
    public void testFibOfOne() {
        assertEquals(1L, Math.fib(1));
    }
    @Test
    public void testFibOfFive() {
        assertEquals(5L, Math.fib(5));
    }

    @Test
    public void testFibOfTen() {
        assertEquals(55L, Math.fib(10));
    }

    @Test
    public void testLibOfNegativeThrowsEx() {
       try {
        lib.Math.fact(-1);
        assertFalse(true);
       }catch (InvalidParameterException e) {
        assertTrue(true);
       }catch (Exception e) {
        assertFalse(true);
       }
    }
}
