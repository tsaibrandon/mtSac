public class Main {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 20;
        String s = "%f %f%n";

        Pair p = new Pair(i, j);

        System.out.println(p);

        p.swap();

        System.out.printf(String.format(s, (double) i, (double) j));
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    public static void swap(Pair k) {
        int tmp = k.a;
        k.a = k.b;
        k.b = tmp;
    }

    public static boolean isEven(int a) {
        return(a & 1) == 0;
    }

    public static boolean isOdd(int a) {
        return !isEven(a);
    }
}
