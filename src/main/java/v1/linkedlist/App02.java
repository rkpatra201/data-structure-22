package v1.linkedlist;


import commons.DsUtils;
import commons.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Question 8-15 both inclusive
 */
public class App02 {

    public static void main(String[] args){

    }

    public Node _8_add_1_to_number_represented_as_linkedList(Node node) {

        Node afterAddingOne = null;
        afterAddingOne = addOne(node);
        // why afterAddingOne.next=null?
        return afterAddingOne;
    }


    public Node _9_add_two_numbers_represented_as_linkedList(Node node1, Node node2){
        Node res = null;
        res = addTwoLists(node1, node2);
        return  res;
    }

    public Node _10_intersection_of_two_sorted_linkedLists(Node node1, Node node2){
        Node res = null;
        res = intersection(node1,node2);
        return res;
    }

    private Node intersection(Node node1, Node node2) {
        Node res = new Node();
        while ((node1 != null) && (node2 != null)){
           if (node1.data == node2.data){
               res.append(node1.data);
               node1 = node1.next;
               node2 = node2.next;
           } else if (node1.data > node2.data){
               node2 = node2.next;
           } else {
               node1 = node1.next;
           }
        }
        return res;
    }

    private Node addTwoLists(Node list1, Node list2) {
        // initializing result list
        Node result = new Node();
        int sum, carry = 0;
        // creating 2 stacks
        Stack<Integer> l1 = new Stack<>();
        Stack<Integer> l2 = new Stack<>();

        // adding list values to stacks
        while (list1 != null){
            l1.add(list1.data);
            list1 = list1.next;
        }
        while (list2 != null){
            l2.add(list2.data);
            list2 = list2.next;
        }

        // running loop untill both stacks empty
        while (!(l1.isEmpty()) || !(l2.isEmpty()))
        {
            int a = 0, b = 0;
            if (!(l1.isEmpty())){
                a = l1.pop();
            }
            if (!(l2.isEmpty())){
                b = l2.pop();
            }
            sum = a + b + carry;
            result.append(sum % 10);
            carry = sum/10;
        }
        // if still carry exists
        if (carry != 0){
            result.append(carry);
        }
        return result;
    }

    private static Node addOne(Node head) {
        Node res = new Node();
        Node temp = head;
        System.out.println();
        int carry = 1, sum = 0;

        while (head != null){
            sum = temp.data + carry;
            res.append(sum % 10);
            head = head.next;
            carry = sum /10;

            // update temp with latest value of head
            temp = head;
        }
        if (carry != 0){
            res.append(carry);
        }

        return res;
    }

}

// A Java recursive program to add two linked lists
/**
 * */
//public class linkedlistATN
//{
//    class node
//    {
//        int val;
//        node next;
//
//        public node(int val)
//        {
//            this.val = val;
//        }
//    }
//
//    // Function to print linked list
//    void printlist(node head)
//    {
//        while (head != null)
//        {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//    }
//
//    node head1, head2, result;
//    int carry;
//
//    /* A utility function to push a value to linked list */
//    void push(int val, int list)
//    {
//        node newnode = new node(val);
//        if (list == 1)
//        {
//            newnode.next = head1;
//            head1 = newnode;
//        }
//        else if (list == 2)
//        {
//            newnode.next = head2;
//            head2 = newnode;
//        }
//        else
//        {
//            newnode.next = result;
//            result = newnode;
//        }
//
//    }
//
//    // Adds two linked lists of same size represented by
//    // head1 and head2 and returns head of the resultant
//    // linked list. Carry is propagated while returning
//    // from the recursion
//    void addsamesize(node n, node m)
//    {
//        // Since the function assumes linked lists are of
//        // same size, check any of the two head pointers
//        if (n == null)
//            return;
//
//        // Recursively add remaining nodes and get the carry
//        addsamesize(n.next, m.next);
//
//        // add digits of current nodes and propagated carry
//        int sum = n.val + m.val + carry;
//        carry = sum / 10;
//        sum = sum % 10;
//
//        // Push this to result list
//        push(sum, 3);
//
//    }
//
//    node cur;
//
//    // This function is called after the smaller list is
//    // added to the bigger lists's sublist of same size.
//    // Once the right sublist is added, the carry must be
//    // added to the left side of larger list to get the
//    // final result.
//    void propogatecarry(node head1)
//    {
//        // If diff. number of nodes are not traversed, add carry
//        if (head1 != cur)
//        {
//            // 9 9 9 9
//            //     1 2
//            propogatecarry(head1.next);
//            int sum = carry + head1.val;
//            carry = sum / 10;
//            sum %= 10;
//
//            // add this node to the front of the result
//            push(sum, 3);
//        }
//    }
//
//    int getsize(node head)
//    {
//        int count = 0;
//        while (head != null)
//        {
//            count++;
//            head = head.next;
//        }
//        return count;
//    }
//
//    // The main function that adds two linked lists
//    // represented by head1 and head2. The sum of two
//    // lists is stored in a list referred by result
//    void addlists()
//    {
//        // first list is empty
//        if (head1 == null)
//        {
//            result = head2;
//            return;
//        }
//
//        // first list is empty
//        if (head2 == null)
//        {
//            result = head1;
//            return;
//        }
//
//        int size1 = getsize(head1);
//        int size2 = getsize(head2);
//
//        // Add same size lists
//        if (size1 == size2)
//        {
//            addsamesize(head1, head2);
//        }
//        else
//        {
//            // First list should always be larger than second list.
//            // If not, swap pointers
//            if (size1 < size2)
//            {
//                node temp = head1;
//                head1 = head2;
//                head2 = temp;
//            }
//            int diff = Math.abs(size1 - size2);
//
//            // move diff. number of nodes in first list
//                                // 1 2 (head 2)
//            node temp = head1; // 1, 2, 9 (head 1)
//            while (diff-- >= 0)
//            {
//                cur = temp;
//                temp = temp.next;
//            }
//
//            // get addition of same size lists
//            addsamesize(cur, head2);
//
//            // get addition of remaining first list and carry
//            propogatecarry(head1);
//        }
//        // if some carry is still there, add a new node to
//        // the front of the result list. e.g. 999 and 87
//        if (carry > 0)
//            push(carry, 3);
//
//    }
//
//    // Driver program to test above functions
//    public static void main(String args[])
//    {
//        linkedlistATN list = new linkedlistATN();
//        list.head1 = null;
//        list.head2 = null;
//        list.result = null;
//        list.carry = 0;
//        int arr1[] = { 9, 9, 9 };
//        int arr2[] = { 1, 8 };
//
//        // Create first list as 9->9->9
//        for (int i = arr1.length - 1; i >= 0; --i)
//            list.push(arr1[i], 1);
//
//        // Create second list as 1->8
//        for (int i = arr2.length - 1; i >= 0; --i)
//            list.push(arr2[i], 2);
//
//        list.addlists();
//
//        list.printlist(list.result);
//    }
//}
//
//// This code is contributed by Rishabh Mahrsee
