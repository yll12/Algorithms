package algo.hackerrank;

import java.io.*;
import java.util.*;

public class CountingTheWays {

    static int MAX = 1000000007;
    static Scanner in = new Scanner(System.in);
    static double[][] table;
    
    public static void main(String[] args) {
        int n = ri();
        int[] A = ria(n);
        double L = in.nextDouble();
        double R = in.nextDouble();
        double result = 0;
        if (R > Integer.MAX_VALUE) {
            for (double i = L; i <= R; i++) {
                result = (result + F(A, i)) % MAX;
            }
        } else {
            result += count(A, A.length, R);
            for (int i = (int) L; i < R; i++) {
                result = (result + table[i][A.length-1]) % MAX;
            }
        }
        pi(result);
    }

    private static double F(int[] A, double x) {
        return count2(A, A.length, x);
    }

    private static double count(int[] A, int m, double n) {
        table = new double[(int) (n+1)][m];
        for (int i = 0; i < m; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i < n+1; i++)
        {
            for (int j = 0; j < m; j++)
            {
                double x = (i-A[j] >= 0)? table[i - A[j]][j]: 0;
     
                double y = (j >= 1)? table[i][j-1]: 0;
     
                table[i][j] = x + y;
            }
        }
        return table[(int) n][m-1];
    }

    private static double count2(int[] A, int m, double n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (m <= 0) {
            return 0;
        }
        return count(A, m - 1, n) + count(A, m, n - A[m - 1]);
    }

    private static void pi(double result) {
        System.out.println(String.format("%.0f", result));
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

    // 1 is true, 0 is false
    private static boolean intToBool(int input) {
        if (input < 0 || input > 1) {
            return true;
        }
        return input == 1;
    }

}
