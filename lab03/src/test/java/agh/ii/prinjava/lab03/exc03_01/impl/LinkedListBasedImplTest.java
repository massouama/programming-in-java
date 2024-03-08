package agh.ii.prinjava.lab03.exc03_01.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    @Test
    void enqueueShouldAddElementToQueue() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void dequeueShouldReturnAndRemoveTheFirstElement() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        int dequeuedElement = queue.dequeue();
        assertEquals(1, dequeuedElement);
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void numOfElemsShouldReturnTheCorrectNumber() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        assertEquals(0, queue.numOfElems());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.numOfElems());
        queue.dequeue();
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void peekShouldReturnTheFirstElementWithoutRemoving() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        int peekedElement = queue.peek();
        assertEquals(1, peekedElement);
        assertEquals(2, queue.numOfElems());
    }

    @Test
    void dequeueOnEmptyQueueShouldThrowException() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        Exception exception = assertThrows(IllegalStateException.class, queue::dequeue);
        assertEquals("The queue is empty", exception.getMessage());
    }

    @Test
    void peekOnEmptyQueueShouldThrowException() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        Exception exception = assertThrows(IllegalStateException.class, queue::peek);
        assertEquals("The queue is empty", exception.getMessage());
    }
}
