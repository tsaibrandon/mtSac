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
        //long a;
        long b = 20; 
        // long c = max(a, b);
        int c = (int)max(a,b);
        float pi = 3.14159f; //you cant try to put a larger value into a smaller one so we need to force the thing

        a += b; // a = a + b

        //shift operator
        b <<= 2;

        a = b = c;

        System.out.println(a);
        System.out.println(b);
        System.out.println(a + " " + b + " " + c);
    }

    //using the turnary operator
    private static int max(int a, int b) { return a > b ? a : b;}
    private static int min(int a, int b) { return a < b ? a : b;}
    private static long max(long a, long b) { return a > b ? a : b;}
    private static long min(long a, long b) { return a < b ? a : b;}
}
