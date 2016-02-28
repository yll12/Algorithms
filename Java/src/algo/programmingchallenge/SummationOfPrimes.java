package algo.programmingchallenge;

import java.io.*;
import java.util.*;

public class SummationOfPrimes {

    // Print the Nth prime number
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long[] lsumOfPrimes = new long[1000001];
        generateAllPrimesUpTo(1000000, lsumOfPrimes);
        for (long i = 0; i < t; i++) {
            int n = in.nextInt();
            System.out.println(lsumOfPrimes[n]);
        }
    }
    
    // This method uses Sieve of Eratosthenes
    private static void generateAllPrimesUpTo(int n, long[] lprimes) {
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
        lprimes[1] = 0;
        for (int i = 1; i < primes.length; i++) {
            if (primes[i]) {
                lprimes[i] = lprimes[i - 1] + i;
            } else {
                lprimes[i] = lprimes[i - 1];
            }
        }
    }
    
}