package algo.javapractise;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(5);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(5);
        set2.add(3);
        System.out.println(set1.equals(set2));
        Set<Set<Integer>> sets = new HashSet<>();
        sets.add(set1);
        sets.add(set2);
    }

}
