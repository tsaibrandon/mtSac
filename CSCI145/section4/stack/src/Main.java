public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();

        for (int i = 1; i <= 16; i++) {
            System.out.print(i + " ");
            s.push(i);
        }

        System.out.println();

        while(!s.empty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }

        System.out.println();
    }


}
