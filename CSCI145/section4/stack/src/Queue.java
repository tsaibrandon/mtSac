public class Queue {
    private final int INITIAL_STORE_SIZE;
    private final int SCALING_FACTOR;

    private int[] store;
    int front;
    int back;
    int count;

    public Queue() {
        INITIAL_STORE_SIZE = 20;
        SCALING_FACTOR = 2;

        store = new int[INITIAL_STORE_SIZE];
        front = back - 1;
        count = 0;
    }

    public void enqueue(int value) {
        if(count >= store.length) resize();

        back = ++back % store.length;

        if(empty()) front = back;

        store[back] = value;

        ++count;
    }

    public void dequeue() {
        if(empty()) 
            throw new RuntimeException("dequeue on an empty queue");
        
        front = ++front % store.length;

        --count;

        if(count == 0) front = back = -1;
    }

    public int peek() { 
        if(empty()) 
            throw new RuntimeException("peek on an empty queue");
        return store[front]; 
    }

    public boolean empty() { return count == 0; }

    private void resize() {
        int[] tmpStore = new int[store.length * SCALING_FACTOR];

        for (int i = 0; i < count; i++) {
            tmpStore[i] = store[front++];
            front = ++front % store.length; 
        }

        store = tmpStore;
        front = 0;
        back = count - 1; 
    }



}
