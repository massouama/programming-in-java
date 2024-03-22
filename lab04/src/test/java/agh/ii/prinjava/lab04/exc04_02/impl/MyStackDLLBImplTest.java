package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {

    private MyStack<Integer> stackOfInts;

    @BeforeEach
    void setUp() {
        stackOfInts = MyStack.create();
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
    void pushIncreasesStackSize() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());
    }

    @Test
    void popDecreasesStackSize() {
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void popReturnsLastPushedItem() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.pop());
        assertEquals(1, stackOfInts.pop());
    }

    @Test
    void peekReturnsLastPushedItemWithoutRemoval() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
        assertEquals(2, stackOfInts.pop());
        assertEquals(1, stackOfInts.numOfElems());
    }

    @Test
    void poppingFromEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, stackOfInts::pop);
    }

    @Test
    void peekingIntoEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, stackOfInts::peek);
    }
}
