package v1.linkedlist;


import commons.Node;

import java.util.HashSet;

/**
 * Question 0-7 both inclusive.
 * 
 * Must answer 0-7 questions and beyond question 7 you can 
 * answer in this class only if you want.
 */
public class App01
{


    public static void main(String[] args)
    {


    }
    public Node _01_Reverse_LinkedList(Node node) {
//        Node curr = node;
//        Node prev = null;
//        while (curr != null) {
//            Node temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
        //node = prev;
//        return  node;

        //Recursive
        Node head = node;
        if(head == null || head.next == null){
            return node;
        }
        Node newHead = _01_Reverse_LinkedList(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;

    }

    public Node _02_Reverse_LinkedList_In_A_Group(Node head, int a){
        if(head == null)
            return null;
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        while(count < a && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null)
            head.next = _02_Reverse_LinkedList_In_A_Group(next,a);
        return  prev;
    }

    public  boolean _03_Detect_Loop_In_A_LinkedList(Node node){
        HashSet<Node> h = new HashSet<Node>();
        while (node != null){
            if(h.contains(node))
                return true;
            h.add(node);
            node = node.next;
        }
        return false;
    }

    public  int _04_Detect_And_Remove_Loop_In_LinkedList(Node node){
        Node slow = node;
        Node fast = node;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                remove_Loop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    void remove_Loop(Node loop, Node head){
        Node ptr1 = loop;
        Node ptr2 = loop;
        int a = 1;
        while (ptr1.next != ptr2){
            ptr1 = ptr1.next;
            a++;
        }
        ptr1 = head;
        ptr2 = head;
        for(int i = 0; i<a ; i++){
            ptr2 = ptr2.next;
        }
        while (ptr2 != ptr1){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr2.next != ptr1){
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }

    public Node _05_Find_First_Node_Of_Loop_In_LinkedList(Node head){
        if(head == null || head.next == null)
            return null;
        Node slow = head;
        Node fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast)
            return null;
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void   _06_Remove_Duplicates_From_Sorted_LinkedList(Node node){
        Node curr = node;
        while (curr != null){
            Node temp = curr;
            while (temp != null && temp.data == curr.data){
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    public  void  _07_Remove_Duplicates_From_Un_Sorted_LinkedList(Node head){
        Node ptr1 = null;
        Node ptr2 = null;
        Node dup = null;
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null){
            ptr2 = ptr1;
            while (ptr2.next != null){
                if (ptr1.data == ptr2.next.data){
                    ptr2.next = ptr2.next.next;
                    System.gc();
                }
                else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    public  void _08_Move_Last_Element_To_From_Of_LinkedList(Node head){
        if(head == null || head.next == null)
            return;
        Node secondLast = null;
        Node last = head;
        while (last.next != null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = head;
        head = last;
    }




}