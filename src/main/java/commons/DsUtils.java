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


    // 192.168.1.38
    public static List<Integer> linkedListAsArray(Node node) {
        Node last = node;
        Node temp = node;
        List<Integer> list = new ArrayList<>();
        list.add(temp.data);
        temp = temp.next;
        while (temp != null) {
            if (last == temp) {
                break;
            }
            list.add(temp.data);
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

    public static TreeNode toMirrorTree(TreeNode node) {
        if (node == null)
            return null;
        TreeNode left = toMirrorTree(node.left);
        TreeNode right = toMirrorTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    /**
     * 50
     * 30     70
     * 20  40  60 80
     *
     * @return
     */
    public static TreeNode getDefaultTree() {
        TreeNode root = buildTree(new int[]{50, 30, 20, 40, 70, 60, 80});
        return root;
    }

    public static TreeNode buildTree(int... arr) {
        TreeNode root = null;
        for (int i : arr) {
            root = insertRec(root, i);
        }
        return root;
    }

    private static TreeNode insert(int key) {
        TreeNode root = insertRec(null, key);
        return root;
    }

    /* A recursive function to
       insert a new key into BST */
    private static TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }
}
