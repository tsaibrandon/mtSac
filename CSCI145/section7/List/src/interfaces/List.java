package interfaces;

import exception.InvalidArgumentException;
import interfaces.Cloneable;

public interface List<T extends Comparable<T> & Cloneable<T>> {

    /** Retruns the item at position i, i is zero indexed.
     * @param int: index of the item to be returned
     */
    T get(int idx);

    /** Sets the item at position i to item x, i is zero indexed.
     * @param int: index at which to update an item
     * @param T: int item with which to update
     */
    void set(int idx, T item);

    /** Adds item x to the end of the list
     * @param T: item to add
     */
    void add(T item);

    /** Removes the item at position i, shifiting subsequent items, i is zero indexed.
     * @param int: index at which to remove an item
     */
    void remove(int idx); 

    /**  Removes the first occurence of item x.
     * @param T: the item to be removed
     */
    void remove(T item) throws InvalidArgumentException;

    /** Inserts item x at position i, shifiting subsequent items, i is zero indexed.
     * @param int: the index at which to insert the item
     * @param T: the item to insert
     */
    void insert(int idx, T item);

    /** Returns the number of items in the list.
     * @return item count
     */
    int size();

    /** returns true if the list is empty, false otherwise.
     * @return boolean: true if empty, flase otherwise
     */
    boolean isEmpty();

    /** Returns the index of the first occurence of item x.
     * @param T: item to be found
     * @return int: index of item found or -1 if not found 
     */
    int find(T item);

    /** Returns a string representation of the list.
     * @return String: string representation of list 
     */
    String toString();
}
