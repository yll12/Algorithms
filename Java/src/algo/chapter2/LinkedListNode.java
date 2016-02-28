package algo.chapter2;

class LinkedListNode {
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d) {
            data = d;
        }

        public void add(int data) {
            LinkedListNode end = new LinkedListNode(data);
            LinkedListNode n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
