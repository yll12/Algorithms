package algo.hackerrank;

import java.io.*;
import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String k = in.next();
            int lens1_s2 = k.length();
            if (lens1_s2 % 2 != 0) {
                System.out.println(-1);
                continue;
            }
            String s1 = k.substring(0, lens1_s2 / 2);
            String s2 = k.substring(lens1_s2 / 2, lens1_s2);
            Map<Character, Integer> freqs1 = new HashMap<>();
            Map<Character, Integer> freqs2 = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                if (freqs1.containsKey(s1.charAt(j))) {
                    freqs1.put(s1.charAt(j), freqs1.get(s1.charAt(j)) + 1);    
                } else {
                    freqs1.put(s1.charAt(j), 1);
                }
            }
            
            for (int j = 0; j < s2.length(); j++) {
                if (freqs2.containsKey(s2.charAt(j))) {
                    freqs2.put(s2.charAt(j), freqs2.get(s2.charAt(j)) + 1);    
                } else {
                    freqs2.put(s2.charAt(j), 1);
                }                
            }
            int totalToDelete = 0;
            for (Map.Entry<Character, Integer> entry : freqs2.entrySet()) {
                char letter = entry.getKey();
                int freq = entry.getValue();
                if (freqs1.containsKey(letter)) {
                    if (freqs1.get(letter) < freq) {
                        totalToDelete += freq - freqs1.get(letter);
                    }
                } else {
                    totalToDelete += freq;
                }
            }
            System.out.println(totalToDelete);
        }
    }
}