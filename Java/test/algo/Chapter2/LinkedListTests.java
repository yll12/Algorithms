package algo.Chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import algo.Chapter2.LinkedListNode;
import algo.Chapter2.LinkedLists;

public class LinkedListTests {

    @Test
    public void removeDubTest1() {
        LinkedListNode actual = new LinkedListNode(1);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(3);
        actual.add(3);
        actual.add(4);
        actual.add(4);
        
        LinkedLists.removeDup(actual);
        
        LinkedList<Integer> expected = new LinkedList<Integer>(
                Arrays.asList(1, 2, 3, 4));
        
        for (Integer s : expected) {
            assertEquals(s, (Integer) actual.data);
            actual = actual.next;
        }
    }

}
