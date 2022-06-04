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

    public Node _01_reverse_linkedlist(Node node) {
        Node prev=null;
        Node current=node;
        Node next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        node=prev;
        return node;
    }

    public Node _02_reverse_linkedlist_in_a_group_of_given_size(Node node,int k){
        Node current=node;
        Node prev=null;
        Node next=null;
        int count=0;
        while(count<k && current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        if(next!=null)
            node.next=_02_reverse_linkedlist_in_a_group_of_given_size(next,k);
        return prev;
    }


public Boolean _03_detect_loop_in_a_linkedlist(Node head){
        Node low =head;
        Node high=head;
        while(high!=null && high.next!=null){
            low=low.next;
            high=high.next.next;
            if(low==high){
                return true;
            }
    }
        return false;
}
public Node _04_deleteloop(Node head) {
    Node low = head;
    Node high = head;
    while (low != null && high != null && high.next != null) {
        low = low.next;
        high = high.next.next;
        if (low == high) {
            break;
        }
    }
    if (low == head) {
        while (high.next != low) {
            high = high.next;
        }
        high.next = null;
    } else if (low == high) {
        low = head;
        while (low.next != high.next) {
            low = head;
            while (low.next != high.next) {
                low = low.next;
                high = high.next;
            }
            high.next = null;
        }
    }
return low;
}
    public Node _05_firstnode_of_loop(Node head){
        Node low=head;
        Node high=head;
        while(low!=null && high!=null && high.next!=null){
            low=low.next;
            high=high.next.next;
            if(low==high){
                break;
            }
        }
        if(low!=high)return null;
        low=head;
        while(low!=high){
            low=low.next;
            high=high.next;
        }
        return low;
    }
    public Node  _06_remove_duplicates_in_a_sorted_linkedlist (Node head) {
        Node current = head;
        while (current != null) {
            Node temp = current;
            while (temp != null && temp.data == current.data) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        return head;
    }
    public void _07_remove_duplicates_in_a_unsorted_linkedlist (Node head){

        HashSet<Integer> set=new HashSet<>();
          Node curr=head;
          Node prev=null;
          while(curr!=null && curr.next != null) {

              if (!set.contains(curr.data)) {
                  prev.next = curr.next;
              } else {
                  curr = curr.next;
                  prev = curr;
              }
              curr = prev.next;
          }

    }
  public Node _08_middle_element (Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
  }
  public Node _09_reversedll(Node head){
     Node cur=head;
     if(cur==null || cur.next==null)
         return  head;
     while(cur.next!=null)
         cur=cur.next;
     head=cur;
     cur.next=cur.prev;
     cur.prev=null;
     cur=cur.next;
     while(cur.prev!=null){
         Node temp =cur.next;
         cur.next=cur.prev;
         cur.prev=temp;
         cur=cur.next;
     }
     cur.prev=cur.next;
     cur.next=null;
     return head;
  }
}

