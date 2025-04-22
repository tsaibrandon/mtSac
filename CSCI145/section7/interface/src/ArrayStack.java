public class ArrayStack implements StackInterface {

    private static final int SCALING_FACTOR = 2;
    private static final int INITIAL_SIZE = 32;
    private int[] store;
    private int top;

    public ArrayStack() {
        store = new int[INITIAL_SIZE];
        top = -1;
    }

    @Override
    public void push(int value) {
        
        if(top == store.length) resize();

        store[++top] = value;
    }

    

    @Override
    public void pop() {
        if(empty()) throw new EmptyStackException("pop on an empty stack");

        --top;
    }

    @Override
    public int peek() {
        if(empty()) throw new EmptyStackException("peek on an empty stack");

        return store[top];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void resize() {
        int[] newStore = new int[store.length * SCALING_FACTOR];

        for (int i = 0; i < store.length; i++)
            newStore[i] = store[i];

        store = newStore;
    }
    

}