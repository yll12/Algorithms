package algo.chapter2;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    Node head;
    private static int count;
    
    public MyLinkedList() {
    }
    
    public void append(T data) {
        Node end = new Node(data, null);
        Node curr = head;
        
        if (head == null) {
            head = end;
            count++;
            return;
        }
        
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = end;
        count++;
    }

    public T get(int index) {
        if (size() < index) {
            throw new IndexOutOfBoundsException();
        } 
        int current = 0;
        Node currNode = head;
        while (currNode.next != null && current < index) {
            currNode = currNode.next;
            current++;
        }
        return currNode.data;
    }
    
    public void remove(T data) {
        if (head == null) {
            throw new NoSuchElementException();
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        
        Node prev = null;
        Node curr = head;
        while (!curr.data.equals(data)) {
            if (curr.next == null) {
                throw new NoSuchElementException();
            }
            prev = curr;
            curr = curr.next;
        }
        count--;
        prev.next = curr.next;
    }
    
    public int size() {
        return count;
    }

    class Node {
        Node next = null;
        T data;
        
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

