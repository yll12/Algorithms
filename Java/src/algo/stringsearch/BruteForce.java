package algo.stringsearch;

import java.util.LinkedList;
import java.util.List;

public class BruteForce {

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new LinkedList<>();
        int len_text = text.length();
        int len_pattern = pattern.length();
        for (int i = 0; i < len_text - len_pattern; i++) {
            if (isSubStringAt(text, pattern, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSubStringAt(String text, String pattern, int i) {
        int len_pattern = pattern.length();
        for (int j = 0; j < len_pattern; j++) {
            if (text.charAt(i + j) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String text = "abcaabaababaca";
        String pattern = "aba";
        System.out.println(search(text, pattern));
    }
    
}
