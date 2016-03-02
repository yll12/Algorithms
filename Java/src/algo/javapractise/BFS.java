package algo.javapractise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    
    // https://www.hackerrank.com/challenges/bfsshortreach 
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    static int[] parent;
    static int numNodes;
    static int numEdges;
    static Scanner in;
    
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            numNodes = in.nextInt();
            numEdges = in.nextInt();
            init();
            initializeAdjList();
            int startNode = in.nextInt() - 1;
            bfs(startNode);
            //printResult(startNode); 
            optionalPrintTree(startNode);
        }
    }

    // Shows the traversal from startNode to end node
    // e.g. 1 -> 2
    //      1 -> 3
    //      1 -> 2 -> 4
    // this is same as 
    //      1 
    //     / \
    //    2   3
    //    |
    //    4
    private static void optionalPrintTree(int s) {
        StringBuilder traversals = new StringBuilder();
        for (int i = 0; i < numNodes; i++) {
            int currentNode = i;
            traversals.append(Integer.toString(i + 1) + " ");
            while (currentNode != s) {
                currentNode = parent[currentNode];
                traversals.append(Integer.toString(currentNode + 1) + " ");
            }
            System.out.println(traversals.reverse());
            traversals = new StringBuilder();
        }
    }

    //Prints shortest distances of the N-1 nodes from starting position S. 
    //This will be done for all nodes same as in the order of input 1 to N.
    private static void printResult(int startNode) {
        for (int i = 0; i < numNodes; i++) {
            if (i == startNode) {
                continue;
            }
            System.out.print((distance[i] >= 0)? distance[i] * 6 : -1);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void init() {
        adjList = new ArrayList<List<Integer>>(numNodes);
        visited = new boolean[numNodes];
        distance = new int[numNodes];
        parent = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new LinkedList<Integer>());
        }
    }

    private static void initializeAdjList() {
        for (int i = 0; i < numEdges; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
    }

    private static void bfs(int s) {
        visited[s] = true;
        distance[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int y = q.poll();
            for (Integer z : adj(y)) {
                if (!visited[z]) {
                    visited[z] = true;
                    distance[z] = distance[y] + 1;
                    parent[z] = y;
                    q.add(z);
                }
            }
        }
    }

    private static List<Integer> adj(int y) {
        return adjList.get(y);
    }
}