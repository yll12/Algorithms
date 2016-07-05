package algo.hackerrank;

import java.io.*;
import java.util.*;

public class LetterN {

    static Scanner in = new Scanner(System.in);
    static Coordinate[] coordinates;

    public static void main(String[] args) {
        int n = ri();
        coordinates = new Coordinate[n];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Coordinate(ri(), ri());
        }
        int count = 0;
        for (int i = 0; i < coordinates.length - 3; i++) {
            for (int j = i + 1; j < coordinates.length - 2; j++) {
                for (int k = j + 1; k < coordinates.length - 1; k++) {
                    for (int l = k + 1; l < coordinates.length; l++) {
                        count += tryFindN(i, j, k, l);
                    }
                }
            }
        }
        p(count);
    }

    private static int tryFindN(int i, int j, int k, int l) {
        int count = 0;
        if (ok(k, i, l, j)) {
            count++;
            if (checkFurther(k, i, l, j)) {
                count++;
            }
        } else if (ok(k, i, j, l)) {
            count++;
            if (checkFurther(k, i, j, l)) {
                count++;
            }
        } else if (ok(j, i, k, l)) {
            count++;
            if (checkFurther(j, i, k, l)) {
                count++;
            }
        }
        return count;
    }

    private static boolean ok(int i, int j, int k, int l) {
        return okHelper(i, j, k, l) || okHelper(l, j, k, i);
    }

    private static boolean checkFurther(int i, int j, int k, int l) {
        return okHelper(j, l, i, k) || okHelper(k, l, i, j);
    }

    private static boolean okHelper(int i, int j, int k, int l) {
        return okFromBC(coordinates[i], coordinates[j], coordinates[k],
                coordinates[l]);
    }

    private static boolean okFromBC(Coordinate A, Coordinate B, Coordinate C,
            Coordinate D) {
        return isRight(B, C, A) && isLeft(B, C, D) && smallerThan90(A, B, C)
                && smallerThan90(B, C, D);
    }

    private static boolean isLeft(Coordinate A, Coordinate B, Coordinate P) {
        return sides(A, B, P) == -1;
    }

    private static boolean isRight(Coordinate A, Coordinate B, Coordinate P) {
        return sides(A, B, P) == 1;
    }

    private static int sides(Coordinate A, Coordinate B, Coordinate P) {
        int x = P.x;
        int y = P.y;
        int x1 = A.x;
        int y1 = A.y;
        int x2 = B.x;
        int y2 = B.y;
        int d = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1);
        if (d < 0) {
            return -1;
        } else if (d > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean smallerThan90(Coordinate X, Coordinate Y,
            Coordinate Z) {
        double angle = angleBetween(X, Y, Z);
        return 0.000001 <= angle && angle <= 90.000001;
    }

    // arccos((D12^2 + D13^2 - D23^2) / (2 * D12 * D13))
    public static double
            angleBetween(Coordinate X, Coordinate Y, Coordinate Z) {
        double D12 = distanceBetween(X, Y);
        double D13 = distanceBetween(X, Z);
        double D23 = distanceBetween(Y, Z);
        return Math.toDegrees(Math.acos((D12 * D12 + D13 * D13 - D23 * D23)
                / (2 * D12 * D13)));
    }

    public static double distanceBetween(Coordinate dis, Coordinate dat) {
        int x1 = dis.x;
        int y1 = dis.y;
        int x2 = dat.x;
        int y2 = dat.y;
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
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

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate that = (Coordinate) obj;
        return that.x == this.x && that.y == this.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
