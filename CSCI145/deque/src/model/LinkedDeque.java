package model;

import exception.EmptyDequeException;
import interfaces.Deque;

public class LinkedDeque<T> implements Deque<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedDeque() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushFront(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            newNode.setNext(front);
            front.setPrev(newNode);
            front = newNode;
        }
        size++;
    }

    @Override
    public void pushBack(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            newNode.setPrev(back);
            back.setNext(newNode);
            back = newNode;
        }
        size++;
    }

    @Override
    public T popBack() throws EmptyDequeException {
        if (isEmpty()) {
            throw new EmptyDequeException("Cannot pop from an empty deque");
        }
        T data = back.getData();
        if (front == back) {
            front = back = null;
        } else {
            back = back.getPrev();
            back.setNext(null);
        }
        size--;
        return data;
    }

    @Override
    public T popFront() throws EmptyDequeException {
        if (isEmpty()) {
            throw new EmptyDequeException("Cannot pop from an empty deque");
        }
        T data = front.getData();
        if (front == back) {
            front = back = null;
        } else {
            front = front.getNext();
            front.setPrev(null);
        }
        size--;
        return data;
    }

    @Override
    public T getFront() throws EmptyDequeException {
        if (isEmpty()) {
            throw new EmptyDequeException("Cannot get front element from an empty deque");
        }
        return front.getData();
    }

    @Override
    public T getBack() throws EmptyDequeException {
        if (isEmpty()) {
            throw new EmptyDequeException("Cannot get back element from an empty deque");
        }
        return back.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
} 