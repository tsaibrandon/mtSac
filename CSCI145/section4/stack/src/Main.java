public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i = 1; i <= 16; i++) {
            System.out.print(i + " ");
            queue.enqueue(i);
        }

        System.out.println();

        while(!queue.empty()) {
            System.out.print(queue.peek() + " ");
            queue.dequeue();
        }

        System.out.println();
    }


}
