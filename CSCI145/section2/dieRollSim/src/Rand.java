import java.util.Random;

public class Rand {
    private static Random rnd = new Random();

    public static int randomIntegerRange(int minima, int maxima) {
        int range = maxima - minima + 1;
        return rnd.nextInt(range) + minima;
    }
    
}   
