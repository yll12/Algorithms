package algo.hackerrank;

import java.io.*;
import java.util.*;

public class GridSearch {

    static int R;
    static int C;
    static int[][] G;
    static int r;
    static int c;
    static int[][] P;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            R = in.nextInt();
            C = in.nextInt();
            G = new int[R][C];
            for (int row = 0; row < R; row++) {
                String rows = in.next();
                for (int col = 0; col < C; col++) {
                    G[row][col] = Character.getNumericValue(rows.charAt(col));
                }   
            }
            r = in.nextInt();
            c = in.nextInt();
            P = new int[r][c];
            for (int row = 0; row < r; row++) {
                String rows = in.next();
                for (int col = 0; col < c; col++) {
                    P[row][col] = Character.getNumericValue(rows.charAt(col));
                }   
            }
            
            boolean result = false;
            outer:
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (containsPattern(row, col)) {
                        result = true;
                        break outer;
                    }
                }   
            }
            System.out.println(result ? "YES" : "NO");
        }
    }
    
    private static boolean containsPattern(int startRow, int startCol) {
        for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i + startRow >= R || j + startCol >= C) {
                        return false;
                    } else {
                        if (G[startRow + i][startCol + j] != P[i][j]) {
                           return false;
                        }
                    }
                }
        }   
        return true;
     
    }
}