package algo.programmingchallenge;

import java.io.*;
import java.util.*;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in);
        }
    }
    
    private static void solve(Scanner in) {
        String x = in.next();
        System.out.println(palindrome(x, 0, x.length() - 1));
    }

    private static int palindrome(String x, int start, int end) {
        if (start == end) {
            return -1;
        } else if (x.charAt(start) == x.charAt(end)) {
            return palindrome(x, start + 1, end - 1);
        } else if (isPalindrome(x, start, end-1)) {
            return end;
        } else if (isPalindrome(x, start+1, end)){
            return start;
        } else {
            return -1;
        }
    }

    private static boolean isPalindrome(String x, int start, int end) {
        for (int i = start; i < end / 2; i++) {
            if (x.charAt(i) != x.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
    
}