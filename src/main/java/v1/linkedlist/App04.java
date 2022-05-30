package v1.linkedlist;


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

        result = _30_merge_LinkedList_And_Sort(right, down);
        Node tempRight = right.right;
        while (tempRight != null) {
            result = _30_merge_LinkedList_And_Sort(result, tempRight);
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
        Node zeroCurrentLast = node0;
        Node oneCurrentLast = node1;
        Node twoCurrentLast = node2;
        while (current != null) {
            Node currNext = current.next;
            if (current.data == 0) {
                zeroCurrentLast.next = current;
                zeroCurrentLast = zeroCurrentLast.next;
                //  zeroCurrent.next = null;
            } else if (current.data == 1) {
                oneCurrentLast.next = current;
                oneCurrentLast = oneCurrentLast.next;
                // oneCurrent.next = null;
            } else if (current.data == 2) {
                twoCurrentLast.next = current;
                twoCurrentLast = twoCurrentLast.next;
                //    twoCurrent.next = null;
            }
            current = currNext;
        }
        zeroCurrentLast.next = node1.next;
        oneCurrentLast.next = node2.next;
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
        Node last = evenList;
        Node prev = null;
        while (current != null) {
            if (current == node) {
                prev = current;
                current = current.next;
                continue;
            }
            Node currNext = current.next;
            if (current.data % 2 == 0) {
                last.next = current;
                last = last.next;

                current.next = null;

                prev.next = currNext;
                current = currNext;
                continue;
            }
            prev = current;
            current = currNext;
        }
        last.next = node;
        return evenList.next;
    }

    public Node _30_merge_LinkedList_And_Sort(Node node1, Node node2) {
        if (node1 != null && node2 != null && node1.data >= node2.data) { // set node1.data is not greater than node2.data
            Node temp = node1;
            node1 = node2;
            node2 = temp;
        }
        Node root = node1;
        Node last = root;
        Node n1Next = null;
        Node n2Next = null;
        while (true) {
            if (node1 == null || node2 == null)
                break;
            if (node1.data < node2.data) {
                //result.append(n1.data);
                n1Next = node1.next;

                last.next = node1;
                last = last.next;
                last.next = null;

                node1 = n1Next;
            } else if (node2.data < node1.data) {
                // result.append(n2.data);
                n2Next = node2.next;

                last.next = node2;
                last = last.next;
                last.next = null;

                node2 = n2Next;
            } else { // both values are same so add twice
                // result.append(n2.data);
                // result.append(n2.data);

                n1Next = node1.next;
                n2Next = node2.next;

                last.next = node1;
                last = last.next;

                last.next = node2;
                last = last.next;
                last.next = null;

                node2 = n2Next;
                node1 = n1Next;
            }
        }
        while (node1 != null) {
            if (root == null) {
                root = node1;
                return root;
            }
            n1Next = node1.next;
            last.next = node1;
            last = last.next;
            last.next = null;
            node1 = n1Next;
        }

        while (node2 != null) {
            if (root == null) {
                root = node2;
                return root;
            }
            n2Next = node2.next;
            last.next = node2;
            last = last.next;
            last.next = null;
            node2 = n2Next;
        }
        // root = root.next;
        System.out.println("r: " + root.asArray());
        return root;
    }


    public Node _32_deleteNodesWhichHaveGreaterValueOnRight(Node root) {

        // input : 10, 20 , 5, 4, 3, 11
        // output: 20, 11

        /**
         * explanation: 10 deleted as 20 is large value present in right of 10
         *    3 deleted as 11 is present at right
         *    4 deleted as 11 is present at right
         *    5 deleted as 11 is present at right
         */


        /**
         * approach:
         *  reverse the list
         *  that means we can traverse from back and keep linking and updating the max values one by one with a tempNode as root.
         *  reverse the tempNode for retain the input order
         */

        /**
         *  input: 10, 20 , 5, 4, 3, 11
         *  reverse: 11, 3, 4, 5, 20, 10
         *  tempNode: 11 max, 20 max
         *  reverse tempNode: 20 - 11
         */

        /**
         *  input: 10, 200, 70, 14, 40, 26, 50
         *  reverse: 50, 26, 40, 14, 70, 200
         *  tempNode: 50, 70, 200
         *  reverse tempNode: 200 , 70, 50
         */

        Node reverseRoot = root.reverse();

        Node tempNode = new Node();
        Node tempNodeLast = tempNode;
        int maxValue = -1;

        Node current = reverseRoot;
        while (current != null) {
            Node currNext = current.next;
            if (current.data > maxValue) {
                current.next = null;

                maxValue = current.data;
                tempNodeLast.next = current;
                tempNodeLast = tempNodeLast.next;
            }
            current = currNext;
        }

        Node newRoot = tempNode.next;
        newRoot.root = newRoot;
        return newRoot.reverse();
    }

    public int _31_multiply_LinkedList(Node root1, Node root2) {
        Node n1 = root1.reverse();
        Node n2 = root2.reverse();
        int v1 = 0;
        int v2 = 0;
        Node current = n1;
        int i = 0;
        while (current != null) {
            v1 = (int) (v1 + Math.pow(10, i++) * current.data);
            current = current.next;
        }

        current = n2;
        i = 0;
        while (current != null) {
            v2 = (int) (v2 + Math.pow(10, i++) * current.data);
            current = current.next;
        }
        return v1 * v2;
    }

//    private Node merge_LinkedList_And_Sort(Node n1, Node n2, boolean isResultNodeN1) {
//        System.out.println("n1: " + n1.asArray());
//        System.out.println("n2: " + n2.asArray());
//        Node result = new Node();
//        while (true) {
//            if (n1 == null || n2 == null)
//                break;
//            if (n1.data < n2.data) {
//                result.append(n1.data);
//                n1 = n1.next;
//            } else if (n2.data < n1.data) {
//                result.append(n2.data);
//                n2 = n2.next;
//            } else { // both values are same so add twice
//                result.append(n2.data);
//                result.append(n2.data);
//                n2 = n2.next;
//                n1 = n1.next;
//            }
//        }
//        if (n1 != null) {
//            Node temp = n1;
//            while (temp != null) {
//                result.append(temp.data);
//                temp = temp.next;
//            }
//
//        }
//
//        if (n2 != null) {
//            Node temp = n2;
//            while (temp != null) {
//                result.append(temp.data);
//                temp = temp.next;
//            }
//        }
//        System.out.println("r: " + result.asArray());
//        return result;
//    }
}