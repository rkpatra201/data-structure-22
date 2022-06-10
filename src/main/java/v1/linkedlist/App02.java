package v1.linkedlist;

import commons.DsUtils;
import commons.Node;

import java.util.Scanner;

/**
 * Question 8-15 both inclusive
 */
public class App02
{


    public static void main(String[] args)
    {

    }
    public Node _08_add_1_to_number_represented_as_linkedlit(Node head) {

        head = addone(head);

        return head;
    }

    static Node reverse(Node head) {
        Node next = null;
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    static Node newNode(int data){
        Node n = new Node();
        n.data = data;
        n.next = null;
        return n;
    }

    public static Node addone(Node head) {
        head = reverse(head);
        boolean f = true;
        Node cur = head;

        while (cur != null && f == true) {    //case 1
            if (cur.next == null && cur.data == 9) {   //for current next null and current data 9
                cur.data = 1;  //make a new node for carry
                Node temp = newNode(0);
                temp.next = head;
                head = temp;
                cur = cur.next;
            }
            else if (cur.data == 9) {    //case 2 if curr is only 9 ,curr data is 0 and iterate
                cur.data = 0;
                cur = cur.next;
            } else {                    //if last node is not 9 current data =curr +1
                cur.data = cur.data + 1;
                cur = cur.next;
                f = false;
            }
        }
        head = reverse(head);
        return  head;
    }

    public  Node _09_add_two_numbers_represented_by_linkedlist(Node head){
        //
        return head;
    }

    public  Node _10_intersection_of_two_sorted_linkedlist(Node node1,Node node2){
      Node a =node1,b=node2;
      while(a!=null && b!=null){
          if(a.data==b.data){
              push(a.data);
              a=a.next;
              b=b.next;
          }
          else if(a.data<b.data){
              a=a.next;
          }
          else
              b=b.next;

      }
      return dummy;

    }
    Node dummy=null;
    Node tail=null;
    Node push(int data){
        Node temp=new Node();
        temp.data=data;
        if(dummy==null){
            dummy=temp;
            tail=temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
        return dummy;
    }


    public  int _11_intersection_point_of_two_linkedlist(Node node1,Node node2){
        int c1=getCount(node1);
        System.out.println("c1 :"+c1);
        int c2=getCount(node2);
        System.out.println("c2 :"+c2);
        int d;
        if(c1>c2){
            d=c1-c2;
            return _getIntersectionNode(d,node1,node2);
        }
        else{
           d= c2-c1;
           return _getIntersectionNode(d,node2,node1);
        }
    }
    int _getIntersectionNode(int d,Node n1,Node n2){
        int i;
        Node current1=n1;
        Node current2=n2;
        for(i=0;i<d;i++){
            if(current1==null){
                return -1;
            }
            current1=current1.next;
        }
        while(current1!=null && current2!=null){
            if (current1.data == current2.data) {
                return current1.data ;
            }
            current1=current1.next;
            current2=current2.next;
        }
        return -1;
}
    int getCount(Node node){
        Node current=node;
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
}
    public  Node _12_merge_sort_for_linkedlist(Node head){
        Node node;
      if(head==null || head.next==null){
          return head;
      }
       Node middle=getMiddle(head);
      Node nextofmiddle=middle.next;
      middle.next=null;
      Node left=_12_merge_sort_for_linkedlist(head);
      Node right=_12_merge_sort_for_linkedlist(nextofmiddle);
      Node sortedlist=sortedmerge(left,right);
      return sortedlist ;
    }
    public static Node getMiddle(Node head){
        if(head==null)
            return head;
            Node slow=head ;
            Node fast =head;
            while (fast.next != null && fast.next.next != null) {
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
    }
    Node sortedmerge(Node a,Node b){
        int val;
        Node result =null;
        if(a==null)
            return b;
        if(b==null)
            return a;
        if(a.data <= b.data){
            result =a;
            result.next=sortedmerge(a.next,b);
        }
        else{
            result =b;
            result.next =sortedmerge(a,b.next);
        }
        return result;
    }
    public Node _13_quicksort_for_linkedlist(Node head){
        return head;

}

    public Node _14_middle_element(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean _15_check_circular_linkedlist(Node head){
      if(head==null)
          return true;
      Node node=head.next;
      while(node !=null && node!= head)
          node=node.next;
      return (node==head);
    }




}