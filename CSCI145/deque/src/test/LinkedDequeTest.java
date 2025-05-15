package test;

import org.junit.Test;

import exception.EmptyDequeException;
import model.LinkedDeque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedDequeTest {
    private LinkedDeque<Integer> deque;

    @Before
    public void setUp() {
        deque = new LinkedDeque<>();
    }

    @After
    public void teardown() {
        list = null;
    }

    @Test
    public void testNewDequeIsEmpty() {
         assertTrue(list.isEmpty());
    }

    
} 