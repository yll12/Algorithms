package algo.hackerrank;

import java.io.*;
import java.util.*;

public class SuperReducedString {

    static Scanner in = new Scanner(System.in);
    
   /*=============================================================================
    | Todo
    *===========================================================================*/
    public static void main(String[] args) {
        String s = rs();
        while (hasDouble(s)) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    s = s.substring(0, i) + s.substring(i+2, s.length());
                }
            }
        }
        if (s.equals("")) {
            p("Empty String");        
        } else {
            p(s);
        }
    }

    private static boolean hasDouble(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }






    /*+----------------------------------------------------------------------
   ||
   ||  Helpers: 
   ||
   |+-----------------------------------------------------------------------         
   ||
   ||  Print: 
   ||
   ||        p(s), pd(d), parray(arr), pdarray(arr), p2darray(matrix);
   ||
   |+-----------------------------------------------------------------------
   ||
   ||  Read:
   ||
   ||        ri(), ria(int n), rd(), rda(int n), rs(), rsa(int n),
   ||            rm(int n, int m);
   ||
   |+-----------------------------------------------------------------------         
   ||
   ||  Extra: 
   ||
   ||        intToBool(int x), buildOcc(int[] arr);
   ||
   ++-----------------------------------------------------------------------*/    
   /*=============================================================================
    | Description: Print helpers
    *===========================================================================*/
    private static <T> void p(T x) {
        System.out.println(x);
    }

    private static void pd(double result) {
        System.out.println(String.format("%.0f", result));
    }
    
    private static void parray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static <T> void parray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    private static <T> void pdarray(T[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }
    
   /*=============================================================================
    | Description:  Read inputs
    *===========================================================================*/
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

    private static double[] rda(int size) {
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

   /*=============================================================================
    | Description:  p2darray: prints 2 dimensional array in a nice format
    |               Optional argument: the size of the width of each column.
    *===========================================================================*/
    public static void p2darray(int[][] matrix) {
        p2darray(matrix, 5);
    }

    public static void p2darray(boolean[][] matrix) {
        p2darray(matrix, 8);
    }

    public static void p2darray(double[][] matrix) {
        p2darray(matrix, 8);
    }
    
    public static void p2darray(char[][] matrix) {
        p2darray(matrix, 5);
    }

    public static void p2darray(int[][] matrix, int len) {
        Integer[][] temp = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        p2darray(temp, len);
    }

    public static void p2darray(boolean[][] matrix, int len) {
        Boolean[][] temp = new Boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        p2darray(temp, len);
    }

    public static void p2darray(double[][] matrix, int len) {
        Double[][] temp = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        p2darray(temp, len);
    }
    
    public static void p2darray(char[][] matrix, int len) {
        Character[][] temp = new Character[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        p2darray(temp, len);
    }

    public static <T> void p2darray(T[][] matrix, int len) {
        String lineSplit = generateLineSplit(matrix, len).toString();
        StringBuilder start = new StringBuilder();
        generateColumnLabel(matrix, len, lineSplit, start);
        generateRows(matrix, len, lineSplit);
    }

    private static <T> void generateRows(T[][] matrix, int len,
            String lineSplit) {
        int i = 0;
        for (T[] row : matrix) {
            StringBuilder sj = new StringBuilder();
            sj.append("|");
            sj.append(center(i + ":", len - 1));
            sj.append("|");
            for (T col : row) {
                sj.append(center(col, len));
                sj.append("|");
            }
            System.out.println(lineSplit);
            System.out.println(sj.toString());
            i++;
        }
        System.out.println(lineSplit);
    }

    private static <T> void generateColumnLabel(T[][] matrix, int len,
            String lineSplit, StringBuilder start) {
        start.append("|");
        start.append(center(" ", len - 1));
        start.append("|");
        for (int i = 0; i < matrix[0].length; i++) {
            start.append(center(" " + i + ":", len));
            start.append("|");
        }
        System.out.println(lineSplit);
        System.out.println(start.toString());
    }

    private static <T> StringBuilder generateLineSplit(T[][] matrix, int len) {
        StringBuilder splitJoiner = new StringBuilder();
        splitJoiner.append("|");
        splitJoiner.append(String.format("%" + (len - 1) + "s", "").replace(
                " ", "-"));
        splitJoiner.append("+");
        for (int index = 0; index < matrix[0].length - 1; index++) {
            splitJoiner.append(String.format("%" + len + "s", "").replace(
                    " ", "-"));
            splitJoiner.append("+");
        }
        splitJoiner.append(String.format("%" + len + "s", "").replace(" ",
                "-"));
        splitJoiner.append("|");
        return splitJoiner;
    }

    private static <T> String center(T col, int len) {
        String out =
                String.format("%" + len + "s%s%" + len + "s", "", col, "");
        float mid = (out.length() / 2);
        float start = mid - (len / 2);
        float end = start + len;
        return out.substring((int) start, (int) end);
    }

   /*=============================================================================
    | Description:  Extra methods
    *===========================================================================*/
    // 1 is true, 0 is false
    private static boolean intToBool(int input) {
        if (input < 0 || input > 1)
        {
            return true;
        }
        return input == 1;
    }

    private static Map<Integer, Integer> buildOcc(int[] residue) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < residue.length; i++) {
            if (freq.containsKey(residue[i])) {
                freq.put(residue[i], freq.get(residue[i]) + 1);
            } else {
                freq.put(residue[i], 1);
            }
        }
        return freq;
    }

}
