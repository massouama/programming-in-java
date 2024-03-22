package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * This class implements a stack using a doubly linked list.
 * It provides standard stack operations including push, pop, peek,
 * and checking the number of elements in the stack.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Represents a node in the doubly linked list.
     * Each node holds an element and references to the next and previous nodes.
     *
     * @param <E> the type of the element stored in the node
     */
    private static class Node<E> {
        E elem; // The element contained in this node
        Node<E> next; // Reference to the next node in the list
        Node<E> prev; // Reference to the previous node in the list

        /**
         * Constructs a new Node instance.
         *
         * @param elem the element to be stored in the node
         */
        Node(E elem) {
            this.elem = elem;
        }
    }

    /**
     * Implements a doubly linked list to support stack operations.
     * Provides methods to add, remove, and access the first element,
     * which are used for stack operations.
     */
    private static class DLinkList<E> {
        private Node<E> head = null; // The head of the list, representing the top of the stack
        private int size = 0; // The number of elements in the list

        /**
         * Adds an element to the beginning of the list.
         * This method supports the push operation of the stack.
         *
         * @param elem the element to be added
         */
        void addFirst(E elem) {
            Node<E> newNode = new Node<>(elem);
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            size++;
        }

        /**
         * Removes and returns the element from the beginning of the list.
         * This method supports the pop operation of the stack.
         *
         * @return the element that was removed
         * @throws IllegalStateException if the list (stack) is empty
         */
        E removeFirst() {
            if (head == null) throw new IllegalStateException("Stack is empty");
            E elem = head.elem;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return elem;
        }

        /**
         * Returns the first element of the list without removing it.
         * This method supports the peek operation of the stack.
         *
         * @return the first element of the list
         * @throws IllegalStateException if the list (stack) is empty
         */
        E getFirst() {
            if (head == null) throw new IllegalStateException("Stack is empty");
            return head.elem;
        }

        /**
         * Returns the number of elements in the list (stack).
         *
         * @return the size of the list
         */
        int size() {
            return size;
        }
    }

    /**
     * Removes the element at the top of the stack and returns it.
     * This method implements the pop operation.
     *
     * @return the element that was removed from the top of the stack
     */
    @Override
    public E pop() {
        return elems.removeFirst();
    }

    /**
     * Adds an element to the top of the stack.
     * This method implements the push operation.
     *
     * @param x the element to be added to the stack
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * This method implements the peek operation.
     *
     * @return the element at the top of the stack
     */
    @Override
    public E peek() {
        return elems.getFirst();
    }
}
