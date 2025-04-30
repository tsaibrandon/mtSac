package model;

import java.security.InvalidKeyException;

import exception.InvalidArgumentException;
import interfaces.Cloneable;
import interfaces.List;

public class LinkedList<T extends Comparable<T> & Cloneable<T>> implements List<T>{

    private int count;
    private Node head;
    private Node tail;

    public LinkedList() {
        count = 0;
        head = tail = null;
    }

    @Override
    public T get(int idx) {
        if(!isValidIdx(idx)) throw new IndexOutOfBoundsException();

        return nodeAt(idx).getItem();
    }

    @Override
    public void set(int idx, T item) {
        if(!isValidIdx(idx)) { throw new IndexOutOfBoundsException(); }
        
        nodeAt(idx).setItem(item);
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<T>(item, tail, null);

        if(isEmpty()) {
            head = tail = newNode;
        }else {
            tail.setNext(newNode);
            tail = newNode;
        }

        ++count;
    }

    @Override
    public void remove(int idx) {
        if(isValidIdx(idx)) throw new IndexOutOfBoundsException();

        Node<T> delNode = nodeAt(idx);

        deleteNode(delNode);
    }

    @Override
    public void remove(T item) throws InvalidArgumentException {
        if(item == null) throw new InvalidArgumentException();

        Node<T> delNode = nodeWith(item);

        if(delNode == null) throw new InvalidArgumentException();

        deleteNode(delNode);
    }
    
    @Override
    public void insert(int idx, T item) {
        if(idx == count) {
            add(item);
            return;
        }

        if(!isValidIdx(idx) || idx != count) throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<T>(item);

        if(count == 0) 
            insertNodeAtFront(newNode);
        else 
            insertInternalNode(nodeAt(idx), newNode);
    }

    @Override
    public int size() { return count; }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int find(T item) {
        return indexOf(item);
    }   
   
    /** assumptions:
     * lis not empty
     * idx is valid
     */ 
    private Node<T> nodeAt(int idx) {
        Node<T> ptr = head;

        while(idx > 0) {
            ptr = ptr.getNext();
            --idx;
        }

        return ptr;
    }

    /** returns -1 if item is not contained */
    private Node<T> nodeWith(T item) {
        Node<T> ptr = head;

        while(ptr != null) {
            if(ptr.getItem().compareTo(item) == 0)
                return ptr;

            ptr = ptr.getNext();
        }

        return ptr;
    }
    /** reutrns -1 if the item i snot contained */
    private int indexOf(T item) {
        Node<T> ptr = head;
        int idx = 0;

        while(ptr != null) {
            if(ptr.getItem().compareTo(item) == 0)
                return idx;
            
            ++idx;

            ptr = ptr.getNext();
        }

        return -1;
    }

    

    private boolean isValidIdx(int idx) {
        return idx >= 0 && idx < count;
    }

    /** node is not null */
    private void deleteNode(Node<T> node) {
        
        if(node == head) deleteHead();
        else if(node == tail) deleteTail();
        else deleteInternalNode(node);

        --count;
    }

    private void deleteHead() {
        head = head.getNext();
        head.setPrev(null);
    }

    private void deleteInternalNode(Node<T> node) {
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);
    }

    private void deleteTail() {
        tail = tail.getPrev();
        tail.setNext(null);
    }

    private void insertInternalNode(Node<T> ptr, Node<T> node) {
        // ptr is in the position at which the insertion happens
        node.setNext(ptr);
        node.setPrev(ptr.getPrev());
        ptr.getPrev().setNext(node);
        ptr.setPrev(node);
    }

    private void insertNodeAtFront(Node<T> newNode) {
        // if list is empty then the add function was called 
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }
}
