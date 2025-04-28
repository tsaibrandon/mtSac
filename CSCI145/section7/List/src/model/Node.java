package model;

import interfaces.Cloneable;
import interfaces.List;

public class Node <T extends Comparable<T> & Cloneable<T>> {

    private T item;
    private Node<T> prev;
    private Node<T> next;

    public Node(T item, Node<T> prev, Node<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public Node(T item) {
        this(item, null, null);
    }

    public Object getItem() {
        return item.copy();
    }

    public void setItem(T item) {
        this.item = item.copy();
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
