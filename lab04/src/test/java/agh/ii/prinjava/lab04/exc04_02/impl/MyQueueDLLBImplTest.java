package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

    private MyQueue<Integer> queueOfInts;

    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.create();
    }

    @AfterEach
    void tearDown() {
        queueOfInts = null; // Clean up after each test
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void enqueueAndDequeueWorkProperly() {
        queueOfInts.enqueue(10);
        assertFalse(queueOfInts.isEmpty());
        assertEquals(10, queueOfInts.dequeue());
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void dequeueOnEmptyQueueReturnsNull() {
        assertNull(queueOfInts.dequeue());
    }

    @Test
    void peekOnEmptyQueueReturnsNull() {
        assertNull(queueOfInts.peek());
    }

    @Test
    void peekReturnsTheFirstElementWithoutRemovingIt() {
        queueOfInts.enqueue(20);
        queueOfInts.enqueue(30);
        assertEquals(20, queueOfInts.peek());
        assertFalse(queueOfInts.isEmpty());
        assertEquals(20, queueOfInts.dequeue());
        assertEquals(30, queueOfInts.peek());
    }
}
