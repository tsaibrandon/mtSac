package model;

public class Node <T extends Comparable<T>> {

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
        return item;
    }

    public void setItem(T item) {
        this.item = item;
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
