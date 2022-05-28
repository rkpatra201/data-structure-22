package v1.linkedlist;


import commons.DsUtils;
import commons.Node;

/**
 * Question 25-35 both inclusive
 */
public class App04 {

    public static void main(String[] args) {

    }

    public boolean _25_traverseLinkedList_LessThan_O_n() {
        // todo logic //
        return false;
    }

    public String _26_quickSort_Arrays_MergeSort_LinkedList() {
        return null;
    }

    public Node _27_flatten_A_LinkedList(Node node) {
        Node result = null;

        // merge 2 linked list is the approach
        Node right = node.right;
        Node down = node;

        result = merge_LinkedList_And_Sort(right, down, false);
        Node tempRight = right.right;
        while (tempRight != null) {
            result = merge_LinkedList_And_Sort(result, tempRight, true);
            tempRight = tempRight.right;
        }
        System.out.println("final result: " + result.asArray());
        return result;
    }

    public Node _28_sort_LinkedList_With_0_1_2(Node node) {
        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        Node current = node;
        Node zeroCurrent = node0;
        Node oneCurrent = node1;
        Node twoCurrent = node2;
        while (current != null) {
            Node currNext = current.next;
            if (current.data == 0) {
                zeroCurrent.next = current;
                zeroCurrent = zeroCurrent.next;
                //  zeroCurrent.next = null;
            } else if (current.data == 1) {
                oneCurrent.next = current;
                oneCurrent = oneCurrent.next;
                // oneCurrent.next = null;
            } else if (current.data == 2) {
                twoCurrent.next = current;
                twoCurrent = twoCurrent.next;
                //    twoCurrent.next = null;
            }
            current = currNext;
        }
        zeroCurrent.next = node1.next;
        oneCurrent.next = node2.next;
        return node0.next;
    }

    public Node _34_find_NthNode_FromEnd(Node node, int n) {
        Node front = node;
        Node back = node;

        while (n != 0) {
            front = front.next;
            n--;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }


    public Node _33_segregate_even_odd_linked_list_1(Node root) {

        Node prev = null;
        Node current = root;
        while (current != null) {
            if (current.data % 2 == 0) {
                // detach/delete the current node
                prev.next = current.next;
                Node temp = current;
                temp.next = null;
                current = prev.next;

                // attach/insert the current node before root
                temp.next = root;
                root = temp;
                continue;
            }
            prev = current;
            current = current.next;
        }
        return root;
    }

    public Node _33_segregate_even_odd_linked_list(Node node) {
        Node current = node;
        Node evenList = new Node();
        Node evenListCurrent = evenList;
        Node prev = null;
        while (current != null) {
            if (current == node) {
                prev = current;
                current = current.next;
                continue;
            }
            Node currNext = current.next;
            if (current.data % 2 == 0) {
                evenListCurrent.next = current;
                current.next = null;
                evenListCurrent = evenListCurrent.next;

                prev.next = currNext;
                current = currNext;
                continue;
            }
            prev = current;
            current = currNext;
        }
        evenListCurrent.next = node;
        return evenList.next;
    }

    private Node merge_LinkedList_And_Sort(Node n1, Node n2, boolean isResultNodeN1) {
        System.out.println("n1: " + n1.asArray());
        System.out.println("n2: " + n2.asArray());
        Node result = new Node();
        while (true) {
            if (n1 == null || n2 == null)
                break;
            if (n1.data < n2.data) {
                result.append(n1.data);
                n1 = n1.next;
            } else if (n2.data < n1.data) {
                result.append(n2.data);
                n2 = n2.next;
            } else { // both values are same so add twice
                result.append(n2.data);
                result.append(n2.data);
                n2 = n2.next;
                n1 = n1.next;
            }
        }
        if (n1 != null) {
            Node temp = n1;
            while (temp != null) {
                result.append(temp.data);
                temp = temp.next;
            }

        }

        if (n2 != null) {
            Node temp = n2;
            while (temp != null) {
                result.append(temp.data);
                temp = temp.next;
            }
        }
        System.out.println("r: " + result.asArray());
        return result;
    }
}