package agh.ii.prinjava.lab04.lst04_03;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * Implements the {@link MyStack} interface using a doubly linked list.
 * This implementation provides a stack (LIFO - Last In, First Out data structure)
 * where elements are added to and removed from the top of the stack.
 *
 * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Inner static class representing a node in a doubly linked list.
     * Each node stores a reference to an element and links to both the next and the previous nodes in the list.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        E elem;
        Node<E> next;
        Node<E> prev;

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
     * Inner static class for a doubly linked list, designed to support stack operations.
     * Provides methods for adding to the front, removing from the front, and retrieving the first element.
     */
    private static class DLinkList<E> {
        private Node<E> head = null; // The head of the list, representing the top of the stack
        private int size = 0; // The number of elements in the list

        /**
         * Adds an element to the front of the list.
         * Corresponds to pushing an element onto the stack.
         *
         * @param elem the element to add
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
         * Removes and returns the element from the front of the list.
         * Corresponds to popping an element from the stack.
         *
         * @return the element removed from the front of the list
         * @throws IllegalStateException if the list is empty
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
         * Returns the element at the front of the list without removing it.
         * Corresponds to peeking at the top element of the stack.
         *
         * @return the element at the front of the list
         * @throws IllegalStateException if the list is empty
         */
        E getFirst() {
            if (head == null) throw new IllegalStateException("Stack is empty");
            return head.elem;
        }

        /**
         * Returns the number of elements in the list.
         *
         * @return the size of the list
         */
        int size() {
            return size;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        return elems.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        return elems.getFirst();
    }
}
