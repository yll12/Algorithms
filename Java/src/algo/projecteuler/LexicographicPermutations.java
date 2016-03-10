package algo.projecteuler;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler024/submissions/code/5494430
// This program reads number of test cases t, and n, return Nth permutation of "abcdefghijklm";
public class LexicographicPermutations {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong() - 1; // Since string is 0 indexed
            String x = "abcdefghijklm";
            printNthPermutation(x, n);
            System.out.println();
        }
    }
    
    // This print 1 character at a time
    private static void printNthPermutation(String x, long n) throws Exception {
        if (x.length() == 0) {
            return;
        } 
        int rotation = x.length() - 1;
        int factorial = fact(rotation);
        int charIndex = (int) (n / factorial);
        System.out.print(x.charAt(charIndex));
        printNthPermutation(x.substring(0, charIndex) + x.substring(charIndex + 1, x.length()), n % factorial);
    }
    
    // Up to 12!
    private static int fact(int n) throws Exception {
        if (n > 12) {
            throw new Exception();
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}