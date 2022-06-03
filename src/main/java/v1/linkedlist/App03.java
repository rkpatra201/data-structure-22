package v1.linkedlist;


import commons.Node;

import java.util.*;

/**
 * Question 16-24 both inclusive
 */
public class App03
{
Node left , head1,head2;


    public static void main(String[] args)
    {

    }
    boolean _17_check_linkedlist_is_palindrome_1(Node node){
        Stack<Integer> stack = new Stack<>();

        while(node!=null){
            stack.push(node.data);
            node = node.next;
        }
        while (node != null) {
            int res = stack.pop();
            if(res!= node.data)
                return false;
        }
          return true;
    }
     boolean _17_check_linkedlist_is_palindrome_2(Node root){
        left=root;
        boolean result = isPalindromeMain(root);
        return result;
    }

     boolean isPalindromeMain(Node head) {


        if (head == null) {
            return true;
        }
        boolean res = isPalindromeMain(head.next);
        if (res == false) {
            return false;
        }
        boolean resSubList = (head.data== left.data);
        left=left.next;
        return resSubList;
    }
     Node[] _16_splitList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next!=head&&fast.next.next!=head){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next.next== head) {
            fast = fast.next;
        }
        head1 = head;
        if (head.next != head) {//required only when we have more than 2 element
            head2 = slow.next;
        }
        fast.next = slow.next;// in case of 2 element only this 2 statement will execute and the head1 statement
        slow.next = head;
        Node[] heads = new Node[]{head1,head2};
        return heads;
    }
    Node _18_deletionFromCircularList(Node head , int key){
        Node curr = head , prev =null ;
        while(curr.data!=key){
            if(curr.next==head){
                System.out.println(key+" : doesn't exists");
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == head && curr.next == head) {
            head=null;
            return head;
        }
        if (curr == head) {
            prev = head.next;
            while (prev.next!=head){
                prev = prev.next;
            }
            head=curr.next;
            prev.next = head;
        }
        else if (curr.next==head){
            prev.next=head;
        }
        else {
            prev.next=curr.next;
        }
        return head;
    }
     Node _19_reverseDLL(Node root){
        Node   curr = root.last;
        root = curr;
        Node temp;
        while(curr != null){
            temp=curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr=curr.next;
        }
        return root;
    }
     int _20_findPairsOfSum(Node node,int target){
        int count=0;
        List<Integer> list = new ArrayList<>();
        while(node!=null){
            if(list.contains(target-node.data)){
                System.out.println("("+(target-node.data)+","+node.data+")");
                count++;
            }
            list.add(node.data);
            node=node.next;
        }
        return count;
    }
     boolean _15_isCircular( Node head){
        Node temp = head;
        while(temp.next!=null){
            if(temp.next == head){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
     int _21_countTriplets(Node node, int i) {
        Node ptr1 = node , ptr2 ;
        int count=0;
        HashMap<Integer,Node> map = new HashMap<>();
        while (ptr1!=null){
            map.put(ptr1.data ,ptr1);
                ptr1 = ptr1.next;
        }
        for (ptr1=node;ptr1!=null;ptr1=ptr1.next){
            for (ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next){
                int sum = ptr1.data+ ptr2.data;
                if(map.containsKey(i-sum)&&map.get(i-sum)!=ptr1&&map.get(i-sum)!=ptr2){
                    count++;
                }
            }
        }
        return (count/3);
    }
     Node _22_sortKDllUsingPQ(Node node, int i) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        Node head = null, last = null;
        for (int j = 0; j <=i && node!=null ; j++) {
            pq.add(node);
            node= node.next;
        }
        while (!pq.isEmpty()){
            if (head == null){
                head = pq.peek();
                head.prev=null;
                last = head;
            }else{
                Node peek =pq.peek();
                last.next = peek;
                peek.prev = last;
                last = peek;
            }
            pq.poll();
            if(node!=null){
                pq.add(node);
                node = node.next;
            }
        }
        last.next = null;
        return head;
    }

     Node _22_sortKDll(Node node , int k) {
       Node head= node;
        for (Node i = node.next;i!=null;i=i.next){
            Node j=i;
            int c=k;
            while(c>=0 && j.prev!=null && j.data<j.prev.data){
                Node temp = j.prev.prev;
                Node temp1 = j.prev;
                Node temp2 = j.next;
                j.prev.next = temp2;
                j.prev.prev =j;
                j.next = temp1;
                j.prev = temp;
                if (temp!=null){
                    temp.next =j;
                }if (temp2!=null){
                    temp2.prev = temp1;
                }

                if (j.prev == null) {
                    head =j;
                }
                c--;
            }
        }

        return head;
    }

     Node _23_rotateByNnode(Node node, int n) {
        Node curr = node;
        Node head = node;

        int count =1;
        if (curr == null || n==0) {
            return head;
        }
        while (count<n && curr != null){
            curr = curr.next;
            count++;
        }
        if (curr == null){
            System.out.println("list contain less node than asked to rotate");
            return  head;
        }
        Node temp = curr;
        while (curr.next!=null){
            curr= curr.next;
        }
        curr.next = node;
        node.prev = curr;
        head = temp.next;
        temp.next = null;
        head.prev = null;
        return  head;
    }
     Node _24_rotateInGroup(Node node, int n) {
        int count = 0;
        Node curr = node, next  = null ,newHead =null ;
        node.prev = null;
        if (node == null) {
            return null;
        }
        while (curr!=null && count++<n){
            newHead = curr;
            next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            curr = curr.prev;
        }
        if(count>n){
            Node remaning = _24_rotateInGroup(curr,n);
            node.next =remaning;
            if (remaning != null) {
                remaning.prev = node;
            }
        }
        return  newHead;

    }



}