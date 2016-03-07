package algo.matrixrotation;

import java.io.*;
import java.util.*;

public class MatrixRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int R = in.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }    
        }
        Position[][] positions = new Position[M][N];

        generateRotatedPosition(positions, M, N, R);
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[positions[i][j].row][positions[i][j].col] + " ");
            }    
            System.out.println();
        }
       
    }
    
    private static void generateRotatedPosition(Position[][] positions, int M, int N, int R) {
        int totalLayers = countLayers(M, N);
        for (int layer = 0; layer < totalLayers; layer++) {
            // To iterate layer by layer
            List<Position> iterator = new LinkedList<>();
            initializeIterator(M, N, layer, iterator);
            int maxStep = maxSteps(M, N, R, layer);
            int steps = R % maxStep;
            for (int j = 0; j < iterator.size(); j++) {
                Position curr = iterator.get(j);
                positions[curr.row][curr.col] = iterator.get((maxStep - steps + j) % iterator.size());
            }
        }
    }

    private static void initializeIterator(int M, int N, int i,
            List<Position> iterator) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        for (first = i; first < M - i; first++) {
            iterator.add(new Position(first, i));
        }
        first--;
        for (second= i + 1; second < N - i; second++) {
            iterator.add(new Position(first, second));
        }
        second--;
        for (third= M - i - 2; third >= i; third--) {
            iterator.add(new Position(third, second));
        }
        for (fourth = N - i - 2; fourth > i; fourth--) {
            iterator.add(new Position(i, fourth));
        }
    }
    
    private static int maxSteps(int M, int N, int R, int layer) {
        return ((M - 1 - 2 * layer) * 2 + (N - 1 - 2 * layer) * 2);
    }
    
    private static int countLayers(int M, int N) {
        return Math.min(M, N) / 2;
    }
}

class Position {
    int row;
    int col;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public String toString() {
        return String.format("(%d, %d)", row, col);
    }
    
}
