package algo.utils;

public class Utils {

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

}
