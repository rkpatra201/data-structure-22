package v1.linkedlist;


import commons.Node;

import java.util.Stack;

/**
 * Question 16-24 both inclusive
 */
public class App03
{


    public static void main(String[] args)
    {

    }
    Node head1 ;
    Node head2 ;
    public void _16_spilt_circular_linkedlist(Node head){
        System.out.println(head.asArray());
        Node slow=head;
        Node fast=head;

        if(head==null){
            return ;
        }
        while(fast.next!=head && fast.next.next!=head){
            fast=fast.next.next;
            slow=slow.next;
        }

        if(fast.next.next==head){
            fast=fast.next;
        }
        head1=head;
        System.out.println(head1.data);
        if(head.next!=head){
            head2=slow.next;
            System.out.println(head2.data);
        }
        fast.next=slow.next;
        slow.next=head;
//        System.out.println(head1.asArray());
//        System.out.println(head2.asArray());
    }

    public boolean _17_check_if_the_linkedlist_is_palindrome(Node head){
        boolean palindrom = true;
        Node slow=head;
        Stack<Integer> s=new Stack<>();
        while(slow!=null) {
            s.push(slow.data);
            slow = slow.next;
        }
        int i;
        while(head!=null){
            i=s.pop();
            if(i==head.data){
                 palindrom=true ;
            }
            else
            {
                palindrom=false;
                break;
            }
            head=head.next;
        }
        return palindrom;
    }

    public Node _18_deletion_from_a_circular_linkedlist(Node head,int key){
       if(head==null)  //list is empty
            return head;
        Node curr=head;
        Node prev=new Node();
        while(curr.data!=key){   //list is not empty
            if(curr.next==head)
                System.out.println("given node is not found" + "in the list");
            break ;
        }
        prev=curr;
        curr=curr.next;
    if(curr == head && curr.next==head){ // for only node
        head=null;
        return head;
    }
    if(curr == head){ // list has more than one node and the deletion is 1st node
        prev=head;
        while(prev.next!=null)
            prev=prev.next;
        head=curr.next;
        prev.next=head;
    }
    else if(curr.next==head){ // for the last node
        prev.next=head;
    }
    else{                    // if the deleted node is neither 1st and last node
        prev.next=curr.next;
    }

        return head;
    }

    public Node _19_reversedll(Node head) {
        Node cur = head;
        if (cur == null || cur.next == null)
            return head;
        while (cur.next != null)
            cur = cur.next;
        head = cur;
        cur.next = cur.prev;
        cur.prev = null;
        cur = cur.next;
        while (cur.prev != null) {
            Node temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            cur = cur.next;
        }
        cur.prev = cur.next;
        cur.next = null;
        return head;
    }

    public void _20_find_pair_with_given_sum_in_doubly_linkedlist(Node head,int x){
        Node first=head;
        Node second=head;
        while(second.next!=null)
            second=second.next;
        boolean found= false;
        while(first != second && second.next!=first){
            if ((first.data+ second.data)==x)
            {
                found =true;
                System.out.println("("+ first.data +"  ,"+ second.data +")");

            first=first.next;
            second =second.next;
            }
          else{
              if((first.data + second.data)<x)
                  first=first.next;
              else
                  second =second.prev;
        }


        }
        if(found==false)
            System.out.println("no pair found");


    }
    public void _20_find_pair_with_given_sum_in_doubly_linkedlist_in_naive_algo(Node head,int x){
        Node first,second;
        for(first=head;first!=null;first=first.next){
            for (second=first.next;second!=null;second=second.next){
                if ((first.data + second.data) == x){
                    System.out.println("("+first.data + "," + second.data +")");
                }
            }
        }
    }
    public int _21_count_triplets_in_a_shorted_doubly_linkedlist(Node head,int s){
        int count=0;
        Node ptr1,ptr2,ptr3;
        for(ptr1=head;ptr1!=null;ptr1=ptr1.next)
            for(ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next)
                for(ptr3=ptr2.next;ptr3!=null;ptr3=ptr3.next)
                    if((ptr1.data+ptr2.data+ptr3.data)==s)
                        count++;
        return count;
    }
    public Node _22_sort_a_k_sorted_doubly_linkedlist(Node head,int a){
        if(head==null || head.next==null)
        return head ;
        for(Node i=head.next;i!=null;i=i.next){
            Node j=i;
            while(j.prev !=null && j.data <j.prev.data){
                Node temp =j.prev.prev;
                Node temp2=j.prev;
                Node temp3=j.next;
                j.prev.next=temp3;
                j.prev.prev=j;
                j.prev=temp;
                j.next=temp2;
                if(temp!=null)
                    temp.next=j;
                if(temp3 != null)
                    temp3.prev=temp2;

            }
            if(j.prev==null)
                head =j;
        }
        return head;


    }
    public Node _23_rotate_doubly_linkedlist_by_n_nodes(Node head,int N){
        if (N ==0)
            return head;
        Node current =head;
        int count =1 ;
        while(count < N &&  current !=null){
            current =current.next;
            count++;
        }
        if(current ==null)
            return head;
        Node NthNode=current ;
        while(current.next != null)
            current =current.next;
        current .next =head;
        (head).prev =current ;
        head =NthNode .next;
        (head).prev =null;
        NthNode .next =null;
        return head ;
    }
    public Node _24_rotate_double_linkedlist_in_a_group_of_given_size(Node head,int m){
        Node current = head;
        Node newHead =null;
        Node next =null;
        int count = 0 ;
        while (current !=null && count < m){
            next =current.next;
            newHead= push(newHead,current);
            current =next;
            count ++;
        }
        if(next !=null){
            head.next =_24_rotate_double_linkedlist_in_a_group_of_given_size(next,m);
            head.next.prev =head;
        }
       return newHead ;

    }
    //
    static Node push(Node head,Node new_node) {
        new_node.prev = null;
        new_node.next = head;
        if(head != null)
            head.prev =new_node;
        head= new_node ;
        return head;

    }
}
