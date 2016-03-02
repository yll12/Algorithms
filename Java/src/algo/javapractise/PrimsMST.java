package algo.javapractise;

import java.io.*;
import java.util.*;

public class PrimsMST {

    
    //TODO: Unfinished
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numNodes = in.nextInt();
        int numEdges = in.nextInt();
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for(int i=0; i<numNodes; i++){
            adjList.add(new ArrayList<Pair<Integer, Integer>>());
        }
        int weight[] = new int[numNodes];
        for (int i = 0; i < numEdges; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            adjList.get(x).add(new Pair<>(y, z));
            adjList.get(y).add(new Pair<>(x, z));
        }
        
    }
}

class Pair<T, V> {
    T node;
    V weight;
    
    Pair(T n, V w) {
        node = n;
        weight = w;
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %s)", node, weight);
    }
}