public class LinkedQueue implements QueueInterface{
    
    private Node head = null;
    private Node tail = null;

    @Override
    public void enqueue(int value) {
        Node tmp = new Node(value);

        if(empty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }

    }

    @Override
    public void dequeue() {
        if(empty()) throw new EmptyQueueException("dequeue on  anempty queue");

        head = head.getNext();

        if(head == null) tail = null;
    }

    @Override
    public int peek() {
        if(empty()) throw new EmptyQueueException("peek on  anempty queue");

        return head.getVal();
    }

    @Override
    public boolean empty() { return head == null; }
}
