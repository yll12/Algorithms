package algo.projecteuler;

import java.util.*;

//https://projecteuler.net/problem=34
public class DigitFactorials {
    
    static Map<Integer, Integer> factorials;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        factorials = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            factorials.put(i, fact(i));    
        }
        long result = 0;
        for (int i = 19; i <= n; i++) {
            if (isCurious(i)) {
                result += i;
            }
        }
        System.out.println(result);
        in.close();
        
    }
    
    private static boolean isCurious(int i) {
        int currentSum = 0;
        int tmp = i;
        while (tmp > 0) {
           int curr = tmp % 10;
           currentSum += factorials.get(curr);
           tmp /= 10;
        }
        return currentSum % i == 0;
    }
    
    private static int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}