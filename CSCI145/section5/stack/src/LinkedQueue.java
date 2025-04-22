public class LinkedQueue {
    
    private Node head = null;
    private Node tail = null;

    public void enqueue(int value) {
        Node tmp = new Node(value);

        if(empty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }

    }

    public void dequeue() {
        if(empty()) throw new EmptyQueueException("dequeue on  anempty queue");

        head = head.getNext();

        if(head == null) tail = null;
    }

    public int peek() {
        if(empty()) throw new EmptyQueueException("peek on  anempty queue");

        return head.getVal();
    }

    public boolean empty() { return head == null; }
}
