package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    private Node first = null;
    private int numOfElems = 0;

    @Override
    public int pop() {
        if (first == null) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        int elem = first.elem;
        first = first.next;
        numOfElems--;
        return elem;
    }

    @Override
    public void push(int x) {
        first = new Node(x, first);
        numOfElems++;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Cannot peek at an empty stack");
        }
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
