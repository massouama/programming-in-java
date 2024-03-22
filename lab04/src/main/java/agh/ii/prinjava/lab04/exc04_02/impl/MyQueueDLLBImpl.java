package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;

/**
 * A doubly-linked list based implementation of the {@link MyQueue} interface.
 * This class provides queue functionalities (FIFO - First In, First Out data structure)
 * where elements are enqueued to the tail and dequeued from the head.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private Node<E> head = null; // Front of the queue
    private Node<E> tail = null; // End of the queue
    private int count = 0; // Number of elements in the queue

    /**
     * Inner static class representing a node in a doubly linked list.
     * Each node stores a reference to an element and links to both the next and the previous nodes in the list.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        E elem; // The element contained in the node
        Node<E> next; // Link to the next node in the queue
        Node<E> prev; // Link to the previous node in the queue

        /**
         * Constructs a new node with the specified element.
         *
         * @param elem the element to store in this node
         */
        Node(E elem) {
            this.elem = elem;
        }
    }

    /**
     * Adds an element to the end of the queue.
     * This method implements the enqueue operation of the queue,
     * adding a new element to the tail.
     *
     * @param x the element to be added to the queue
     */
    @Override
    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    /**
     * Removes and returns the element from the front of the queue.
     * This method implements the dequeue operation of the queue,
     * removing the head element and returning its value.
     *
     * @return the element that was removed from the front of the queue, or null if the queue was empty
     */
    @Override
    public E dequeue() {
        if (head == null) {
            return null; // Queue is empty
        }
        E value = head.elem;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        count--;
        return value;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the count of elements currently in the queue
     */
    @Override
    public int numOfElems() {
        return count;
    }

    /**
     * Retrieves, without removing, the element at the front of the queue.
     * This method implements the peek operation of the queue,
     * allowing observation of the head element without dequeuing it.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public E peek() {
        return (head != null) ? head.elem : null;
    }

}
