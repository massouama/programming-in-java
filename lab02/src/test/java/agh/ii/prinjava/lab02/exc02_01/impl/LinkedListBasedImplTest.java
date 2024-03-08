package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    private StackOfInts stackOfInts;

    @BeforeEach
    void setUp() {
        stackOfInts = new LinkedListBasedImpl();
    }

    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void pop() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.pop());
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void push() {
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty());
    }

    @Test
    void numOfElems() {
        assertEquals(0, stackOfInts.numOfElems());
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());
    }

    @Test
    void peek() {
        stackOfInts.push(2);
        stackOfInts.push(3);
        assertEquals(3, stackOfInts.peek());
        assertEquals(2, stackOfInts.numOfElems()); // Check that peek does not change the number of elements
    }
}
