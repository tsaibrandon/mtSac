public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i >= 0; i--) {
            System.out.println("\rSeconds remaining: " + i + " ");
            Thread.sleep(1000);
        }

    }
}
