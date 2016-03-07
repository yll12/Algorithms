package algo.bitmanipulation;

import java.util.*;

//https://www.hackerrank.com/challenges/acm-icpc-team
public class MinMaxBit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet[] persons = new BitSet[n];
        for (int i = 0; i < n; i++) {
            String line = in.next();
            persons[i] = new BitSet(m);
            for (int j = 0; j < m; j++) {
                persons[i].set(j, line.charAt(j) == '1');    
            }
        }
        int maxTopics = -1;
        int numberOfTeamsAchievingTheMaxTopics = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BitSet curr = (BitSet) persons[j].clone();
                curr.or(persons[i]);
                if(curr.cardinality() > maxTopics) {
                    maxTopics = curr.cardinality();
                    numberOfTeamsAchievingTheMaxTopics = 1;
                } else if (curr.cardinality() == maxTopics) {
                    numberOfTeamsAchievingTheMaxTopics++;
                }
            }
        }
        System.out.println(maxTopics);
        System.out.println(numberOfTeamsAchievingTheMaxTopics);
    }
}