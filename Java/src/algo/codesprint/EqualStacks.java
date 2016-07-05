package algo.codesprint;

import java.io.*;
import java.util.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int[] stack1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            stack1[i] = in.nextInt();
        }
        int[] stack2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            stack2[i] = in.nextInt();
        }
        int[] stack3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            stack3[i] = in.nextInt();
        }
        int[] cumulative1 = buildCumulative(stack1);
        int[] cumulative2 = buildCumulative(stack2);
        int[] cumulative3 = buildCumulative(stack3);
        SortedMap<Integer, Integer> freq = new TreeMap<>(java.util.Collections.reverseOrder());
        populate(freq, cumulative1);
        populate(freq, cumulative2);
        populate(freq, cumulative3);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 3) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println(0);
    }

    private static void populate(SortedMap<Integer, Integer> freq,
            int[] cumulative) {
        for (int i = 0; i < cumulative.length; i++) {
            if (freq.containsKey(cumulative[i])) {
                freq.put(cumulative[i], freq.get(cumulative[i]) + 1);
            } else {
                freq.put(cumulative[i], 1);
            }
        }
    }

    private static int[] buildCumulative(int[] stack) {
        int[] cumulative = new int[stack.length];
        cumulative[0] = stack[stack.length - 1];
        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] = cumulative[i-1] + stack[stack.length - 1 - i];
        }
        return cumulative;
    }
}