public class Main {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 20;

        Pair p = new Pair(i, j);

        System.out.println(p);

        p.swap();

        System.out.println(p);
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


}
