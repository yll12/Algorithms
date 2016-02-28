package algo.chapter1;

public class ArraysAndStrings {

    public static String stringCompress(String x) {
        StringBuilder result = new StringBuilder();

       int count = 0;
        
        for (int i = 0; i < x.length(); i++) {
            count++;
            
            if (i + 1 == x.length() || x.charAt(i) != x.charAt(i + 1)) {
                result.append(x.charAt(i));
                result.append(count);
                count = 0;
            }

        }
        
        if (notsmaller(result.length(), x.length())) {
            return x;
        }
        
        return result.toString();
    }

    private static boolean notsmaller(int x, int y) {
        return x >= y;
    }
    
    public static boolean isRotation(String s1, String s2) {
        int len_s1 = s1.length();
        
        if (len_s1 == s2.length() && len_s1 > 0) {
            String s2s2 = s2.concat(s2);
            return s2s2.contains(s1);    
        }
        
        return false;
    }
    
    public static int[][] zeroMatrix(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyRows(matrix, i);
            }
        }
        
        for (int j = 0; j < columns.length; j++) {
            if (columns[j]) {
                nullifyColumns(matrix, j);
            }
        }
        
        return matrix;
    }
    
    private static void nullifyColumns(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    
    private static void nullifyRows(int[][] matrix, int row) {
        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
    }
   
}
