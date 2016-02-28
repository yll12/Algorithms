package algo.programmingchallenge;

import java.io.*;
import java.util.*;

public class PrimeNumbers {

    // Print the Nth prime number
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        List<Integer> lprimes = new LinkedList<Integer>();
        // We assume N <= 10^4, and the 10,000th prime = 104729
        generateAllPrimesUpTo(104730, lprimes);
        for (long i = 0; i < t; i++) {
            System.out.println(lprimes.get(in.nextInt() - 1));
        }
    }
    
    // This method uses Sieve of Eratosthenes
    private static void generateAllPrimesUpTo(int n, List<Integer> lprimes) {
        if (n < 2) {
            return;
        }
        boolean[] primes = new boolean[n + 1];
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                lprimes.add(i);
            }
        }
    }
}