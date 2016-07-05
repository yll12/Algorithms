package algo.programmingchallenge;

import java.io.*;
import java.util.*;

public class MissingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        
        Map<Integer, Integer> freqA = buildOccurenceTable(A);
        Map<Integer, Integer> freqB = buildOccurenceTable(B);
        List<Integer> missingNumbers = new LinkedList<>();
        
        for (Map.Entry<Integer, Integer> entry : freqB.entrySet()) {
            Integer key = entry.getKey();
            if (!freqA.containsKey(key) || !freqA.get(key).equals(entry.getValue())) {
                missingNumbers.add(key);
            }
        }
        
        Collections.sort(missingNumbers);
        print(missingNumbers);
    }
    
    private static void print(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    
    private static Map<Integer, Integer> buildOccurenceTable(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        return freq;
    }
}