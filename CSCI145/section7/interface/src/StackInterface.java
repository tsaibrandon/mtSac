public interface StackInterface {

    /** Adds a value to the top of the stack
     * @param value: the value to be added
     * @return void
     */
    void push(int value);
    
    /** Removes the top value from the stack
     * @return void
     * @throws EmptyStackException when popping on an empty stack
     */
    void pop();
    
    /** Removes the top value from the stack
     * @return int: the value on the top of the stack
     * @throws EmptyStackException when peeking at an empty stack
     */
    int peek();
    
    /** Checks if stack is empty
     * 
     * @return true if empty and false otherwise
     */
    boolean empty();
}
