package agh.ii.prinjava.lab03.exc03_01;

/**
 * Interface defining the operations for a queue of integers.
 * This interface enforces a FIFO (First-In-First-Out) behavior.
 */
public interface QueueOfInts {

    /**
     * Adds the specified element to the end of the queue.
     *
     * @param x the integer element to add to the queue
     */
    void enqueue(int x);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the integer number of elements currently in the queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the head of the queue.
     *
     * @return the head element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int peek();

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }
}
