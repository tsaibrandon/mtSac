
public class LinkedStack {

    private Node head = null;

    public void push(int val) {
        head = new Node(val, head);
    }

    public void pop() {
        if(empty()) throw new EmptyStackException("pop on an empty stack");

        head = head.next;
    }

    public int peek() {
        if(empty()) throw new EmptyStackException("peek on an empty stack");

        return head.val;
    }

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
