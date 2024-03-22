package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * Defines the contract for a generic stack data structure.
 * A stack is a collection that supports push and pop operations,
 * following the Last-In-First-Out (LIFO) principle.
 *
 * @param <E> the type of elements held in this stack
 */
public interface MyStack<E> {

    /**
     * Removes and returns the element at the top of the stack.
     * This method represents the pop operation of a stack.
     *
     * @return the element removed from the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    E pop();

    /**
     * Adds an element to the top of the stack.
     * This method represents the push operation of a stack.
     *
     * @param x the element to add to the stack
     */
    void push(E x);

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack contains no elements
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    E peek();

    /**
     * Factory method to create a new instance of a stack.
     * This method facilitates the creation of a stack instance without
     * specifying the exact class that implements the stack interface.
     *
     * @param <T> the type of elements the stack will hold
     * @return a new instance of MyStack
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<>();
    }
}
