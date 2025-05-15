package interfaces;

import exception.EmptyDequeException;

public interface Deque<T> {
    /**
     * Adds an element to the front of the deque
     * @param element the element to add
     */
    void pushFront(T element);

    /**
     * Adds an element to the back of the deque
     * @param element the element to add
     */
    void pushBack(T element);

    /**
     * Removes and returns the element at the back of the deque
     * @return the element at the back of the deque
     * @throws EmptyDequeException if the deque is empty
     */
    T popBack() throws EmptyDequeException;

    /**
     * Removes and returns the element at the front of the deque
     * @return the element at the front of the deque
     * @throws EmptyDequeException if the deque is empty
     */
    T popFront() throws EmptyDequeException;

    /**
     * Returns the element at the front of the deque without removing it
     * @return the element at the front of the deque
     * @throws EmptyDequeException if the deque is empty
     */
    T getFront() throws EmptyDequeException;

    /**
     * Returns the element at the back of the deque without removing it
     * @return the element at the back of the deque
     * @throws EmptyDequeException if the deque is empty
     */
    T getBack() throws EmptyDequeException;

    /**
     * Checks if the deque is empty
     * @return true if the deque is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the deque
     * @return the number of elements in the deque
     */
    int size();
}
