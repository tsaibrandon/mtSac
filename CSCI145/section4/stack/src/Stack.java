public class Stack {

    private final int INITIAL_STORE_SIZE;
    private final int SCALING_FACTOR;
    private int[] store;
    private int top;

    public Stack() {
        INITIAL_STORE_SIZE = 15;
        SCALING_FACTOR = 2;

        store = new int[INITIAL_STORE_SIZE];

        top = 0;

    }

    public void push(int value) {
        if(top == store.length) resize();

        store[top++] = value;
    }
         
        
    public void pop() {
        if(empty()) throw new RuntimeException("pop on empty stack");
        
        --top;
    }

    public int peek() {
        if(empty()) throw new RuntimeException("pop on empty stack");
        
        return store[top - 1];
    }

    public boolean empty() { return top == 0; }

    private void resize() {
        int[] tmpStore = new int[store.length * SCALING_FACTOR];

        for (int i = 0; i < store.length; i++) {
            tmpStore[i] = store[i];
        }

        store = tmpStore;
    }

}
