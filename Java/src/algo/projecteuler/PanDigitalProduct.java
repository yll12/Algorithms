package algo.projecteuler;

import java.io.*;
import java.util.*;

public class PanDigitalProduct {

    static int n;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long product = 0;
        for (long x = 1; length(x) <= n; x++) {
            if (isDifferent(x)) {
                for (long a = 1; a <= Math.sqrt(x); a++) {
                    long b = x / a; 
                    if (b * a == x) {
                        long result = concat(concat(a, b), x);
                        if (isPanDigital(result)) {
                            product += x;   
                        }
                    }
                }        
            }
        }
        System.out.println(product);
    }
    
    public static boolean isDifferent(long theNumber) {
       String number = new Long(theNumber).toString();
       Set<Character> set = new LinkedHashSet<Character>();
       for(char c:number.toCharArray()) {
            set.add(Character.valueOf(c));
       }
       return number.length() == set.size();
    }
    
    private static int length(long k) {
        if (k == 0) {
            return 1;
        }
        int length = 0;
        long current = k;
        while (current > 0) {
            current /= 10;
            length++;
        }
        return length;
    }
    
    private static long concat(long x, long y) {
        String x_str = String.valueOf(x);
        String y_str = String.valueOf(y);
        String result = x_str + y_str;
        return Long.parseLong(result);
    }
    
    private static boolean isPanDigital(long x) {
        if (length(x) > n) {
            return false;
        }
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
        
        for (int i = 1; i <= n; i++) {
            if (!checker[i]) {
                return false;
            }
        }
        return true;
    }
}