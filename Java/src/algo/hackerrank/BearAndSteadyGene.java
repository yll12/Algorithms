package algo.hackerrank;

import java.io.*;
import java.util.*;

public class BearAndSteadyGene {

    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String s = in.next();
        Map<Character, Integer> freq = buildFreq(s);
        if (isSteady(freq)) {
            System.out.println("0");
            return;
        }
      
        int minReplace = n;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && !isSteady(freq)) {
                assert (freq.containsKey(s.charAt(j)));
                freq.put(s.charAt(j), freq.get(s.charAt(j)) - 1);
                j++;
            }
            if (isSteady(freq)) {
                minReplace = Math.min(minReplace, j - i);
            }
            freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
        }
        System.out.println(minReplace);
    }

    private static boolean isSteady(Map<Character, Integer> freq) {
        for (Integer x : freq.values()) {
            if (x > n / 4) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> buildFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char i : s.toCharArray()) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        return freq;
    }
}
