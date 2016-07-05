package algo.programmingchallenge;

import java.io.*;
import java.util.*;

// Connected Cell in a Grid
// ref: https://www.hackerrank.com/challenges/connected-cell-in-a-grid
public class AnotherDFS {

    static int rows;
    static int cols;
    static boolean[][] visited;
    static final int DIRECTIONS = 8;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        rows = in.nextInt();
        cols = in.nextInt();
        visited = new boolean[rows][cols];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        List<Integer> sizeConnected = findAllConnected(matrix);
        System.out.println(Collections.max(sizeConnected));
    }
    
    private static List<Integer> findAllConnected(int[][] matrix) {
        List<Integer> lsizeConnected = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    lsizeConnected.add(dfs(matrix, i, j));
                }
            }
        }
        return lsizeConnected;
    }
    
    private static int dfs(int[][] matrix, int row, int col) {
        int size = 1;
        visited[row][col] = true;
        
        int[] rowNbr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int k = 0; k < DIRECTIONS; k++) {
            int adjRow = row + rowNbr[k];
            int adjCol = col + colNbr[k];
            if (withinBoundaries(adjRow, adjCol) 
               && matrix[adjRow][adjCol] == 1
               && !visited[adjRow][adjCol]) {
                size += dfs(matrix, adjRow, adjCol);
            }
        }
        return size;
    }
    
    private static boolean withinBoundaries(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}