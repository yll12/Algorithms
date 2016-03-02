package algo.projecteuler;

import java.util.*;

//https://projecteuler.net/problem=38
public class PanDigital {

    static int k;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        k = in.nextInt();
        for (long i = 2; i <= n; i++) {
            if (isMultiplier(i)) {
                System.out.println(i);
            }
        }
        in.close();
    }
    
    private static boolean isMultiplier(long i) {
        long l = 2;
        long current = i;
        while (length(current) < k) {
            current = concat(l*i, current);
            l++;
        }
        if (length(current) > k) {
            return false;
        }
        return isPanDigital(current);
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