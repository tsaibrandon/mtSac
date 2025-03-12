public class Pair {
    public int a;
    public int b;
    
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void swap() {
        a ^= b;
        b ^= a;
        a ^= b;
    }

    public String toString() {
        return a + " " + b;
    }
}
