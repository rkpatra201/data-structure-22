package v1.linkedlist;


import java.util.Scanner;

/**
 * Question 8-15 both inclusive
 */
public class App02 {
    int count = 0;
    Node head;

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null, next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) {

        // question - 8
        _8_add_1_to_number_represented_as_linkedList();
    }

    private static void _17_check_linkedList_palindrome() {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
    }

    private static void _8_add_1_to_number_represented_as_linkedList() {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        printLinkedList(head);

        head = reverseLinkedList(head);

        head = addOne(head);

        head = reverseLinkedList(head);

        System.out.print("Reversed List is ");
        printLinkedList(head);
    }

    private static Node addOne(Node head) {
        int carry = 1, sum;
        Node res = head, temp = null;
        while (head != null) {
            sum = carry + head.data;
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            head.data = sum;
            temp = head;
            head = head.next;
        }
        if (carry == 1) {
            temp.next = new Node(carry);
        }
        return res;
    }

}