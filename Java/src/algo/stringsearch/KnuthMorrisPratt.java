package algo.stringsearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KnuthMorrisPratt {

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new LinkedList<>();
        int len_text = text.length();
        int len_pattern = pattern.length();
        int[] prefix = new int[len_pattern];
        prefix_func(pattern, prefix);
        int q = 0; // Number of characters matched in pattern
        for (int i = 0; i < len_text; i++) {
            while (q > 0 && text.charAt(i) != pattern.charAt(q)) {
                q = prefix[q - 1];
            }
            if (text.charAt(i) == pattern.charAt(q)) {
                q++;
            }
            if (q == len_pattern) {
                result.add(i - len_pattern + 1);
                q = prefix[q - 1];
            }
        }
        return result;
    }

    private static void prefix_func(String pattern, int[] prefix) {
        int len_pattern = pattern.length();
        prefix[0] = 0;
        int k = 0;
        for (int q = 1; q < len_pattern; q++) {
            while (k > 0 && pattern.charAt(q) != pattern.charAt(k)) {
                k = prefix[k - 1];
            }
            if (pattern.charAt(q) == pattern.charAt(k)) {
                k++;
            }
            prefix[q] = k;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test #1:");
        String text = "abcaabaababaca";
        String pattern = "aba";
        System.out.println(search(text, pattern));
        System.out.println("Test #2:");
        String text2 = "abababacbacbca";
        String pattern2 = "ababac";
        System.out.println(search(text2, pattern2));
    }
    
}
