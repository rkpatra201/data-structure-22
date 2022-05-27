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

        Node right = node.right;
        Node down = node;

        result = merge_LinkedList_And_Sort(right, down, false);
        Node tempRight = right.right;
        while (tempRight != null) {
            result = merge_LinkedList_And_Sort(result, tempRight, true);
            tempRight = tempRight.right;
        }
        System.out.println("final result: "+ result.asArray());
        return result;
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