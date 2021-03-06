// N time N space
package linked_list.problems;

import java.util.HashMap;
import java.util.Map;

public class NthNodeLinkedList_2 {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node oldHead = head;
            head = new Node(data);
            head.next = oldHead;
        }
    }

    private int nthFromTheEnd(int position) throws Exception {
        if (head == null || position < 0) {
            throw new Exception("Invalid position provided");
        }

        Node temp = head;
        Map<Integer, Node> map = new HashMap<>();
        int counter = 0;
        while (temp != null) {
            map.put(counter++, temp);
            temp = temp.next;
        }
        System.out.println(map);

        if (position > map.size()) {
            throw new Exception("Invalid position provided");
        }
        return map.get(map.size() - position - 1).data;
    }


    public static void main(String[] args) throws Exception {
        NthNodeLinkedList_2 linkedList = new NthNodeLinkedList_2();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);

        System.out.println(linkedList.nthFromTheEnd(15));
    }
}
