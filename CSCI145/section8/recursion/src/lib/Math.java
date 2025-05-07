package lib;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class Math {

    private static HashMap<Long, Long> map = new HashMap<>();

    public static long fact(int n) {
        if(n < 0) throw new InvalidParameterException("n must be non negative");

        return fact((long)n);
    }

    public static long fib(int n) {

        if(n < 0) throw new InvalidParameterException("n must be non negative");
        
        return fib((long) n);
    }

    public static long gcd(int a, int b) {

        if(a < 0 || b < 0) throw new InvalidParameterException("n must be non negative");
        
        return recGCD(a, b);
    }

    // private static long fib(long n) {
    //     if(n <= 1) return n;
        
    //     return fib(n - 1) + fib(n - 2);
    // }

    private static long fib(long n) {
        if(n <= 1) return n;

        if(!map.containsKey(n)) 
            map.put(n, fib(n - 1) + fib(n - 2));
            
        return map.get(n);
    }

    private static long fact(long n) {
        if(n <= 1) return 1;

        return n * fact(n -1);
    }

    private static int recGCD(int a, int b) {
        if(b == 0) return a;

        return recGCD(b, a % b);
    }
}
