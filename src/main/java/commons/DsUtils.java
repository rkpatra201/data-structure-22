package commons;

import java.util.ArrayList;
import java.util.List;

public class DsUtils {

    public static Node arrayToLinkedList(int... arr) {

        Node root = buildLinkedList(arr);
        return root;
    }

    public static Node arrayToCircularLinkedList(int... arr) {
        Node root = buildLinkedList(arr);
        root.last.next = root;
        return root;
    }


    public static List<Integer> linkedListAsArray(Node node) {
        Node last = node.last;
        Node temp = node;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.data);
            if (last == temp) {
                break;
            }
            temp = temp.next;
        }
        return list;
    }

    public static void iterateOverLinkedList(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        iterateOverLinkedList(node.next);
    }

    private static Node buildLinkedList(int[] arr) {
        Node root = new Node();
        root.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root.append(arr[i]);
        }
        return root;
    }

    public static Node buildDoubleLinkedList(int... arr) {
        Node root = new Node();
        root.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root.appendDll(arr[i]);
        }
        return root;
    }
}
