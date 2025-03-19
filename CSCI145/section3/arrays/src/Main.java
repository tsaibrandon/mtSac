public class Main {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        int[] array2 = array;

        array2[0] = 100;

        prettyPrint(array);
        prettyPrint(array2);

    }

    public static void prettyPrint(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
            System.out.print((i + " "));
            i++;
        }

        System.out.println("]");
    }
}
