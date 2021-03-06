// 61. How'd you remove duplicates from an unsorted linked list?
// n time n space 
package linked_list_Problems;

import java.util.HashMap;
import java.util.Map;

public class Remove_Duplicates_2 {
    private static Node head;

    private static synchronized void display(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        head = new Node(0);
        Node temp1 = new Node(1);
        Node temp2 = new Node(2);
        Node temp3 = new Node(3);
        Node temp4 = new Node(3);
        Node temp5 = new Node(7);
        Node temp6 = new Node(7);
        Node temp7 = new Node(7);
        Node temp8 = new Node(9);
        Node temp9 = new Node(10);
        Node temp10 = new Node(10);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = temp9;
        temp9.next = temp10;
        temp10.next = null;

        display(head);
        removeDuplicates(head);
        display(head);
    }

    private static void removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            System.out.println("Linked list is either empty or has only 1 element");
            return;
        }
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Node curr = head;
        Node next;
        while (curr.next != null) {
            next = curr.next;
            if (map.containsKey(next.data)) {
                curr.next = next.next;
            } else {
                map.put(next.data, true);
                curr = curr.next;
            }
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
