package Utilities;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNonPrime {

	 

    public static List<Integer> getNumbers() { 
    	List<Integer> values=new ArrayList<Integer>();
        int n = 40;
        int prev = 0;
        int curr = 1;
        while (curr <= n) {
            int fib = prev + curr;
            if (!isPrime(fib)) {
                values.add(fib);
            }
            prev = curr;
            curr = fib;
        }
        return values;
    }

 
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}