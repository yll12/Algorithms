package algo.javapractise;

import java.io.*;
import java.util.*;

public class Solution {

    static int k = 4;
    
    public static void main(String[] args) {
      long x = 12;
      long n = 2147673649L;
      int[] result = new int[10];
      for (int i = 9; i >= 0; i--) {
          result[i] = (int) (n % 10);
          n /= 10;
      }
      System.out.println(Arrays.toString(result));
      String l = "0";
      String r = "0";
      for (int i = 0; i < 5; i++) {
          r += result[i];
      }
      for (int i = 5; i < 5; i++) {
          l += result[i];
      }
      System.out.println(r);
      System.out.println(l);
      for (long a = 1; a <= Math.sqrt(x); a++) {
          long b = x / a; 
          if (b * a == x) {
             /* long result = concat(concat(a, b), x);
              if (isPanDigital(result)) {
                  System.out.println(result);
              }*/
          }
      }
    }
    
    private static long concat(long x, long y) {
        String x_str = String.valueOf(x);
        String y_str = String.valueOf(y);
        String result = x_str + y_str;
        return Long.parseLong(result);
    }
    
    private static boolean isPanDigital(long x) {

        boolean[] checker = new boolean[10];
        for (int i = 0; i <= 9; i++) {
            checker[i] = false;
        }
        long current = x;
        while (current > 0) {
            int digit = (int) current % 10;
            current /= 10;
            checker[digit] = true;
        }
        
        if (checker[0]) {
            return false;
        }
        
        for (int i = 1; i <= k; i++) {
            if (!checker[i]) {
                return false;
            }
        }
        return true;
    }
}