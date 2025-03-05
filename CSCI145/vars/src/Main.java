public class Main {
    public static void main(String[] args) {
        // int counter; //inline comments
        /**
         * multi 
         * line
         * comment
         */
        // char c = 'A';

        long a = 10;
        long b = 20; 
        long c = max(a, b);
    }

    //using the turnary operator
    private static int max(int a, int b) { return a > b ? a : b;}
    private static int min(int a, int b) { return a < b ? a : b;}
    private static long max(long a, long b) { return a > b ? a : b;}
    private static long min(long a, long b) { return a < b ? a : b;}
}
