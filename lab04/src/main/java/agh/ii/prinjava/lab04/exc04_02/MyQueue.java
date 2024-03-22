package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

/**
 * Defines the contract for a generic queue data structure.
 * A queue is a collection designed for holding elements prior to processing.
 * It follows the FIFO (First-In-First-Out) principle, meaning that elements
 * are added to the end and removed from the beginning of the queue.
 *
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param x the element to be added
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the beginning of the queue.
     * If the queue is empty, the behavior is unspecified and depends on the implementation.
     *
     * @return the element at the beginning of the queue
     */
    E dequeue();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the element at the beginning of the queue.
     * If the queue is empty, the behavior is unspecified and depends on the implementation.
     *
     * @return the element at the beginning of the queue
     */
    E peek();

    /**
     * Factory method to create a new instance of a queue.
     * This method allows for a flexible creation of queue instances without
     * specifying the exact class of the queue at the point of creation.
     *
     * Pros:
     * - Provides a simple way to create a queue instance with default implementation.
     * - Encapsulates the instantiation logic, making the client code cleaner.
     *
     * Cons:
     * - Reduces flexibility by tying the interface to a specific implementation.
     * - Makes it harder to switch to a different implementation without changing the interface.
     *
     * @param <T> the type of elements the queue will hold
     * @return a new instance of MyQueue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
