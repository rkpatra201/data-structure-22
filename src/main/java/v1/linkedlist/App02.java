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