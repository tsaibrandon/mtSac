public class EmptyQueueException extends RuntimeException{

    public EmptyQueueException() {
        this("Invalid operation on an epty queue");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}