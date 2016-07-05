package algo.programmingchallenge;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/count-luck
public class MoreGraphs {

    private static Coordinate starting;
    private static Coordinate goal;
    private static char[][] maze;
    private static List<Coordinate> path;
    private static int rows;
    private static int cols;
    private static int[] rowNbr = {-1, 0, 0, 1};
    private static int[] colNbr = {0, -1, 1, 0};
    private static final int DIRECTIONS = 4;
    private static boolean visited[][];
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in);
        }
    }
    
    private static void solve(Scanner in) {
        rows = in.nextInt();
        cols = in.nextInt();
        maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String next = in.next();
            for (int j = 0; j < cols; j++) {
                char x = next.charAt(j);
                maze[i][j] = x;
                if (x == 'M') {
                    starting = new Coordinate(i, j);
                } else if (x == '*') {
                    goal = new Coordinate(i, j);
                }
            }   
        }
        int K = in.nextInt();
        path = new LinkedList<>();
        visited = new boolean[rows][cols];
        backtrack(starting);
        Collections.reverse(path);
        int result = count();
        if (K == count()) {
            System.out.println("Impressed");
        } else {
            System.out.println("Oops!");
        }
    }
    
    private static boolean backtrack(Coordinate current) {
        visited[current.row][current.col] = true;
        if (isLeaf(current)) {
            if (isGoal(current)) {
                path.add(current);
                return true;
            } else {
                return false;
            }
        } else {
            for (Coordinate x : allOptions(current, visited)) {
                if (backtrack(x)) {
                    path.add(current);
                    return true;
                }    
            }
            return false;
        }
    }
    
    private static boolean isLeaf(Coordinate x) {
        return x.equals(goal) || allOptions(x, visited).size() == 0;
    }
    
    private static boolean isGoal(Coordinate x) {
        return x.equals(goal);
    }
    
    private static int count() {
        int result = 0;
        boolean visit[][] = new boolean[rows][cols];
        for (Coordinate x : path) {
            visit[x.row][x.col] = true;
            if (allOptions(x, visit).size() > 1 && !isGoal(x)) {
                result++;
            }
        }
        return result;
    }
    
    private static List<Coordinate> allOptions(Coordinate x, boolean[][] visit) {
        List<Coordinate> options = new LinkedList<>();
        for (int i = 0; i < DIRECTIONS; i++) {
            Coordinate adj = new Coordinate(x.row + rowNbr[i], x.col + colNbr[i]);
            if (withinBoundary(adj) && !isTree(adj) && !visit[adj.row][adj.col]) {
                options.add(adj);
            }
        }
        return options;
    }
    
    private static boolean withinBoundary(Coordinate x) {
        return x.row >= 0 && x.col >=0 && x.row < rows && x.col < cols;
    }
    
    private static boolean isTree(Coordinate x) {
        return maze[x.row][x.col] == 'X';
    }
    
}

class Coordinate {
    int row;
    int col;
    
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Coordinate.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "(" + row + ", " + col +")";
    }
}