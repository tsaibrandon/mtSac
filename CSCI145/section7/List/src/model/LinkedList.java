package model;

import interfaces.List;

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private int count;
    private Node head;
    private Node tail;

    public LinkedList() {
        count = 0;
        head = tail = null;
    }

    @Override
    public T get(int idx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void set(int idx, T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(T item) {
        Node newNode = new Node(item, tail, null);

        if(isEmpty()) {
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }

        ++count;
    }

    @Override
    public void remove(int idx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void insert(int idx, T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void remove(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() { return count; }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int find(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }   
   private class Node {

        private T item;
        private Node prev;
        private Node next;

        public Node(T item, LinkedList<T>.Node prev, LinkedList<T>.Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node(T item) {
            this(item, null, null);
        }
    }

}
