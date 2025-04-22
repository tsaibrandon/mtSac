public interface QueueInterface {

    /** Adds a value to the back of the queue
     * @param int: the value to be added 
     * @return void 
     */
    void enqueue(int value);

    /** Removes the value from th efornt of the queue
     * @return void
     * @throws EmptyQueueException: if called on an empty queue
     */
    void dequeue();

    /** Returns the value at the front of the queue
     * @return int: the value at the front
     * @throws EmptyQueueException: if called on an empty queue
     */
    int peek();

    /** Checks if queue is empty
     * @return true if empty and false otherwise
     */
    boolean empty();


}
