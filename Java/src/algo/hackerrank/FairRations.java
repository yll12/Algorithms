package algo.hackerrank;

import java.io.*;
import java.util.*;

public class FairRations {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = ri();
        int[] B = ria(n);
        int i = 0;
        int count = 0;
        while (i < B.length) {
            if (isEven(B[i])) {
                i++;
            } else {
                int j = i + 1;
                while (j < B.length && isEven(B[j])) {
                    j++;
                }
                if (j == B.length) {
                    p("NO");
                    return;
                }
                count += (j - i) * 2;
                i = j + 1;
            }
        }
        p(count);
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }

    private static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    private static <T> void p(T x) {
        System.out.println(x);
    }

    private static void pd(double result) {
        System.out.println(String.format("%.0f", result));
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

    private static double[] rid(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd();
        }
        return arr;
    }

    private static double rd() {
        return in.nextDouble();
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

    // 1 is true, 0 is false
    private static boolean intToBool(int input) {
        if (input < 0 || input > 1) {
            return true;
        }
        return input == 1;
    }

}
