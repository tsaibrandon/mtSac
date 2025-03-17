public class Main {
    
    private static Status status;
    private static Status s2;
    
    public static void main(String[] args) {
        status = Status.INPLAY;
        s2 = Status.LOST;

        System.out.println((s2 == status) ? "equal" : "not equal");

        s2 = Status.INPLAY;

        System.out.println((s2 == status) ? "equal" : "not equal");

        printStatus();
    }

    public static void printStatus() {
        System.out.printf("the number of status is: %d%n", status.values().length);
        System.out.println(status);
        System.out.printf("it is at position %d%n", status.ordinal());
    }

}
