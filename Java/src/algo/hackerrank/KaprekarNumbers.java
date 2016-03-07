package algo.hackerrank;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/kaprekar-numbers
public class KaprekarNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long p = in.nextLong();
        long q = in.nextLong();
        boolean atLeastOne = false;
        for (long i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                atLeastOne = true;
                System.out.print(i + " ");
            }
        }
        if (!atLeastOne) {
            System.out.println("INVALID RANGE");
        }
    }
    
    private static boolean isKaprekar(long n) {
        int d = countDigits(n);
        long n_square = n * n;
        int n_sq_digits = countDigits(n_square);
        int[] digits = splitIntoDigit(n_square, n_sq_digits);
        String l = "0";
        String r = "0";
        int split = (n_sq_digits % 2 == 0) ? d : d - 1;
        for (int i = 0; i < split; i++) {
            r += digits[i];
        }
        for (int i = split; i < n_sq_digits; i++) {
            l += digits[i];
        }
        return Long.parseLong(l) + Long.parseLong(r) == n;
    }
    
    private static int countDigits(long n) {
        if (n == 0) {
            return 1;
        }
        int digits = 0;
        while (n != 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }
    
    private static int[] splitIntoDigit(long n, int digits) {
        int[] result = new int[digits];
        for (int i = digits - 1; i >= 0; i--) {
            result[i] = (int) (n % 10);
            n /= 10;
        }
        return result;
    }
    
}