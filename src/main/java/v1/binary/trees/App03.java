package v1.binary.trees;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Question 21 - 30 both inclusive
public class App03 {
    int maxDiameter = 0;

    void _01_levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    void _02_reverselevelOrderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            stack.push(top);
            if (top.right != null) queue.add(top.right);
            if (top.left != null) queue.add(top.left);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    int _03_height(TreeNode root) {
        if (root == null) return 0;
        else {
            int lheight = _03_height(root.left);
            int rheight = _03_height(root.right);
            return Math.max(lheight, rheight) + 1;
        }
    }

    int _03_height_1(TreeNode root) {
        int h = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) h++;
            if (temp != null) {
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            } else if (!q.isEmpty()) q.add(null);
        }
        return h;
    }

    int _04_diameterOfTree(TreeNode root) {

        int height = diameter(root);
        return maxDiameter;
    }

    int diameter(TreeNode root) {
        if (root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        maxDiameter = Math.max(maxDiameter, left + right + 1);
        System.out.println(maxDiameter);
        return Math.max(left, right) + 1;
    }

    TreeNode _05_mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = _05_mirrorTree(root.left);
        TreeNode right = _05_mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    void _06_inorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        _06_inorderTraversalWithRecurtion(root.left);
        System.out.print(root.data + " ");
        _06_inorderTraversalWithRecurtion(root.right);
    }

    void _06_inorderTraversalWithoutRecurtion(TreeNode root) { // until null push whenever there is null pop and moved to its right
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }

    }

    void _07_preorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        _07_preorderTraversalWithRecurtion(root.left);
        _07_preorderTraversalWithRecurtion(root.right);
    }

    void _07_preorderTraversalWithoutRecurtion(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) s.push(temp.right);
            if (temp.left != null) s.push(temp.left);
        }
    }

    void _08_postorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        _08_postorderTraversalWithRecurtion(root.left);
        _08_postorderTraversalWithRecurtion(root.right);
        System.out.print(root.data + " ");
    }

    void _08_postorderTraversalWithoutRecurtion(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null) return;
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) s1.push(temp.left);
            if (temp.right != null) s1.push(temp.right);
        }
        while (!s2.isEmpty()) System.out.print(s2.pop().data + " ");
    }
}

