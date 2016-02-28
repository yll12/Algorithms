package algo.chapter2;

import java.util.HashSet;

public class LinkedLists {

    public static void removeDup(LinkedListNode head) {
        HashSet<Integer> table = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (head != null) {
            if (table.contains(head.data)) {
                previous.next = head.next;
            } else {
                table.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

}
