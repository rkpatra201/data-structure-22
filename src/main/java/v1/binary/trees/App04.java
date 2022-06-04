package v1.binary.trees;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question 31 - 34 both inclusive
public class App04 {


    public List<Integer> _01_levelOrderTraversal(TreeNode treeNode) {
        List<Integer> list  = new ArrayList<>();
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
}
