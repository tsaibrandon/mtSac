public class EmptyStackException extends RuntimeException {

    public EmptyStackException(String message) {
        super(message);
    }

    public EmptyStackException() {
        this("invalid operation on an empty stack");
    }
}
