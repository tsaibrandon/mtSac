public class Main {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println("Goodbye cruel world");

        String msg = "Seconds remaining: ";
        //cr moves the cursor to the beginning
        String cr = " \r";
        //String cr = "\r";

        for (int i = 10; i >= 0; i--) {
            /*
             * int i = 10 <-- declaration/initialization
             * i < 0 <-- test
             * i-- <-- update
             * 
             * everything in the for loop is called a statement block
             */

            //this prints the countdown on new lines
            //System.out.println(msg + i);

            //creating a countdown on the same line
            System.out.print(msg + i + cr);
            //System.out.print(cr + msg + i);
            //System.out.print(cr + msg + i + " ");

            //create a delay
            Thread.sleep(1000);
        }
        
        //keeps the line from disappearing after the 0
        System.out.println();
    }
}
