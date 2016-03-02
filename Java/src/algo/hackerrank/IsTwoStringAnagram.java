package algo.hackerrank;

import java.util.*;

public class IsTwoStringAnagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int deletions = 0;
        boolean[] marked = new boolean[b.length()];
        outer:
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j) && !marked[j]) {
                    marked[j] = true;
                    continue outer;
                } 
            }
            deletions++;
        }
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                deletions++;
            }
        }
        System.out.println(deletions);
        in.close();
    }
}