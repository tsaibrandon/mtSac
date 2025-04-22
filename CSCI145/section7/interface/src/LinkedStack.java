
public class LinkedStack implements StackInterface{

    private Node head = null;

    @Override
    public void push(int val) {
        head = new Node(val, head);
    }

    @Override
    public void pop() {
        if(empty()) throw new EmptyStackException("pop on an empty stack");

        head = head.next;
    }

    @Override
    public int peek() {
        if(empty()) throw new EmptyStackException("peek on an empty stack");

        return head.val;
    }

    @Override
    public boolean empty() { return head == null; }

    private class Node {
        int val;
        Node next = null;
        
        Node(int val){
            this(val, null);
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }
}
