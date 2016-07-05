package algo.hackerrank;

import java.io.*;
import java.util.*;

public class DemandingMoney {

    static Scanner in = new Scanner(System.in);
    static Set<Set<Integer>> answers = new HashSet<>();
    static int[] weights; 
    static int N;
    static int M;
    static BitSet[] roads;
    
    public static void main(String[] args) {
        N = ri();
        M = ri();
        weights = ria(N);
        int[][] roadMap = new int[N][N];
        for (int i = 0; i < M; i++) {
            int j = ri() - 1;
            int k = ri() - 1;
            roadMap[j][k] = 1;
            roadMap[k][j] = 1;
        }
        for (int i = 0; i < N; i++) {
            roadMap[i][i] = 1;
        }
        roads = build(roadMap);
        for (int i = 0; i < N; i++) {
            Set<Integer> ans = new HashSet<>();
            BitSet curr = new BitSet(N);
            curr.or(roads[i]);
            search(curr, ans, i);
        }
        evaluateAns();
    }
    
    private static void search(BitSet current, Set<Integer> curr, int node) {
        List<Integer> childIndex = findAllChildren(current);
        Set<Integer> ans = new HashSet<>(curr);
        ans.add(node);
        if (childIndex.size() == 0) {
            answers.add(ans);
        } else {
            for (Integer i: childIndex) {
                BitSet next = (BitSet) current.clone();
                next.or(roads[i]);
                search(next, ans, i);
            }
        }
    }

    private static List<Integer> findAllChildren(BitSet curr) {
        List<Integer> childIndex = new LinkedList<>();
        for (int i = curr.nextClearBit(0); i < N; i = curr.nextClearBit(i+1)) {
            childIndex.add(i);
        }
        return childIndex;
    }

    private static BitSet[] build(int[][] roadMap) {
        BitSet[] roads = new BitSet[N];
        for (int i = 0; i < N; i++) {
            roads[i] = new BitSet();
            for (int j = 0; j < N; j++) {
                roads[i].set(j, intToBool(roadMap[i][j]));
            }
        }
        return roads;
    }

    // 1 is true, 0 is false
    private static boolean intToBool(int input) {
        if (input < 0 || input > 1)
        {
            return true;
        }
        return input == 1;
    }
    
    private static void evaluateAns() {
        int currentMax = 0;
        double count = 0;
        for (Set<Integer> ans : answers) {
            int total = sum(ans);
            if (total > currentMax) {
                double zeros = countZeros(ans);
                currentMax = total;
                count = Math.pow(2, zeros);
            } else if (total == currentMax) {
                double zeros = countZeros(ans);
                count += Math.pow(2, zeros);
            }
        }
        System.out.println(currentMax + " " + String.format("%.0f", count));
    }
    
    private static double countZeros(Set<Integer> ans) {
        int zeros = 0;
        for (Integer k: ans) {
            if (weights[k] == 0) {
                zeros++;
            }
        }
        return zeros;
    }

    private static int sum(Set<Integer> ans) {
        int sum = 0;
        for (Integer x: ans) {
            sum += weights[x];
        }
        return sum;
    }

    private static <T> void p(T x) {
        System.out.println(x);
    }
    
    private static <T> void parray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    private static <T> void pdarray(T[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }
    
    private static int[] ria(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ri();
        }
        return arr;
    }
    
    private static int ri() {
        return in.nextInt();
    }
    
    private static String[] rsa(int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rs();
        }
        return arr;
    }
    
    private static String rs() {
        return in.next();
    }
    
    private static int[][] rm(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[row][col] = ri();
            }
        }
        return matrix;
    }

}
