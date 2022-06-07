package v1.binary.trees;

import commons.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

// Question 31 - 34 both inclusive
public class App04 {


    private boolean pathFinder(TreeNode treeNode, List<TreeNode> paths, int value) {
        if (treeNode == null)
            return false;
        paths.add(treeNode);
        if (treeNode.data == value)
            return true;
        boolean flag = pathFinder(treeNode.left, paths, value) || pathFinder(treeNode.right, paths, value);
        if (flag)
            return true;

        paths.remove(paths.size() - 1);
        return false;
    }

    public List<TreeNode> findPathFromRootToNode(TreeNode treeNode, int value) {
        List<TreeNode> list = new ArrayList<>();
        pathFinder(treeNode, list, value);
        return list;
    }

    public TreeNode _30_findLowestCommonAncestor(TreeNode t, int v1, int v2) {
        List<TreeNode> v1Path = new ArrayList<>();
        pathFinder(t, v1Path, v1);
        List<TreeNode> v2Path = new ArrayList<>();
        pathFinder(t, v2Path, v2);

        TreeNode prevNode = null;
        int i = 0;
        while (true) {
            if (i > v1Path.size() - 1) break;
            if (i > v2Path.size() - 1) break;

            TreeNode t1 = v1Path.get(i);
            TreeNode t2 = v2Path.get(i);

            if (t1 != t2)
                break;
            else {
                prevNode = t1;
            }
            i++;
        }
        return prevNode;
    }

    public List<Integer> _02_reverseLevelOrderTraversal(TreeNode treeNode) {
        List<TreeNode> elements = new ArrayList<>();

        elements.add(treeNode);

        int prevIndex = -1;
        int index = 0;
        while (index != prevIndex) {
            if (index > elements.size() - 1)
                break;
            TreeNode temp = elements.get(index);
            index = index + 1;
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if (left != null) elements.add(left);
            if (right != null) elements.add(right);
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = elements.size() - 1; i >= 0; i--)
            nodes.add(elements.get(i).data);
        return nodes;
    }

    public List<Integer> _01_levelOrderTraversal(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(treeNode);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode polledNode = queue.poll();
            if (polledNode == null) {
                queue.add(null);
                if (queue.peek() == null)
                    break;
                continue;
            }
            System.out.println(polledNode.data);
            list.add((polledNode.data));
            TreeNode right = polledNode.right;
            TreeNode left = polledNode.left;

            if (left != null)
                queue.add(left);
            if (right != null)
                queue.add(right);
        }
        return list;
    }

    public int _03_heightOfTheTree_Rec(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int leftHeight = _03_heightOfTheTree_Rec(treeNode.left);
        int rightHeight = _03_heightOfTheTree_Rec(treeNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int _03_heightOfTheTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(treeNode);
        queue.add(null);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                //System.out.println("========");
                queue.add(null);
                count = count + 1;
                if (queue.peek() == null)
                    break;
                continue;
            }
            //  System.out.println(tempNode.key);
            TreeNode right = tempNode.right;
            TreeNode left = tempNode.left;

            if (left != null)
                queue.add(left);
            if (right != null)
                queue.add(right);
        }
        return count;
    }

    public boolean _24_checkMirrorTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;

        return n1.data == n2.data && _24_checkMirrorTree(n1.left, n2.right) && _24_checkMirrorTree(n1.right, n2.left);
    }

    public void _12_levelOrderDeQueueZigZagTraversal(TreeNode treeNode) {

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(treeNode);
        queue.add(null);
        boolean flag = false;
        System.out.println(queue.peek().data);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.peek();
            if (tempNode == null) {
                flag = !flag;
                System.out.println("========");
                TreeNode reverseTraversal = null;
                while (flag) {
                    reverseTraversal = queue.pollLast();
                    if (reverseTraversal == null) {
                        flag = false;
                        break;
                    }
                    System.out.println(reverseTraversal.data);
                    queue.addFirst(reverseTraversal);
                }
                queue.add(null);
                if (queue.peek() == null)
                    break;
                continue;
            }
            tempNode = queue.poll();
            //  System.out.println(tempNode.key);
            TreeNode right = tempNode.right;
            TreeNode left = tempNode.left;

            if (left != null)
                queue.add(left);
            if (right != null)
                queue.add(right);
        }
    }

    public boolean _13_balancedBst(TreeNode treeNode) {
        if (treeNode == null)
            return true;

        int leftHeight = _03_heightOfTheTree_Rec(treeNode.left);
        int rightHeight = _03_heightOfTheTree_Rec(treeNode.right);

        int heightDiff = Math.abs(leftHeight - rightHeight);

        if (heightDiff <= 1 && _13_balancedBst(treeNode.left) && _13_balancedBst(treeNode.right))
            return true;

        return false;

    }
}
