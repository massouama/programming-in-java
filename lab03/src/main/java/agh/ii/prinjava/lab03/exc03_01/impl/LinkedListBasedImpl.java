package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;

    private static class Node {
        int elem;
        Node next;
        Node prev;
        /**
         * Constructor for Node that sets the element value.
         *
         * @param elem the integer element stored in this node
         */
        Node(int elem) {
            this.elem = elem;
        }
        /**
         * Constructor for Node that sets the element value and its next and previous nodes.
         *
         * @param elem the integer element stored in this node
         * @param next the next node in the linked list
         * @param prev the previous node in the linked list
         */
        Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * Adds an element to the end of the queue.
     * This method appends the specified element to the end of this queue.
     *
     * @param x the element to be inserted
     */
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }
    /**
     * Retrieves and removes the head of this queue.
     * This method removes and returns the first element of this queue.
     *
     * @return the head of this queue
     * @throws IllegalStateException if this queue is empty
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        int retValue = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        numOfElems--;
        return retValue;
    }
    /**
     * Returns the number of elements currently in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }
    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws IllegalStateException if this queue is empty
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return first.elem;
    }
}
