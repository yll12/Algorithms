package algo.codesprint;

import java.io.*;
import java.util.*;

public class RoadsInHackerLand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] distances = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (x != y) {
                    distances[x][y] = 1000;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            int j = in.nextInt() - 1;
            int k = in.nextInt() - 1;
            int weight = in.nextInt();
            distances[j][k] = (int) Math.pow(2, weight);
            distances[k][j] = (int) Math.pow(2, weight);
        }
        int[][] result = floyd(distances, N);
        System.out.println(Integer.toBinaryString(sum(result)));
    }

    private static int sum(int[][] result) {
        int total = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length; j++) {
                total += result[i][j];
            }
        }
        return total;
    }

    private static int[][] floyd(int[][] distances, int n) {
        int[][] A = distances.clone();
        int[][] result = new int[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x != y) {
                    result[x][y] = 1000;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    result[x][y] = Math.min(A[x][y], A[x][i] + A[i][y]);
                }
            }
            A = result.clone();
        }
        return result;
    }

}
