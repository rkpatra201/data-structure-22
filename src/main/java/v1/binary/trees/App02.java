package v1.binary.trees;

import commons.TreeNode;
import javafx.beans.binding.When;
import sun.reflect.generics.tree.Tree;

import java.util.*;

// Question 11 - 20 both inclusive
public class App02 {
    public ArrayList<Integer> _1_level_order_traversal_by_height_calc(TreeNode treeNode){
        ArrayList<Integer> traversalRes = new ArrayList<>();
        int height = _3_get_Height_Of_Binary_Tree(treeNode);
        System.out.println("Height : "+height);

        for (int i = 1; i <= height; i++){
            traversalRes = levelOrderTraversal(treeNode, height);
        }
        return traversalRes;
    }

    private ArrayList<Integer> levelOrderTraversal(TreeNode treeNode, int level) {
        ArrayList<Integer> list = new ArrayList<>();
        if (treeNode == null){
            list.add(null);
        } else if (level == 1){
            list.add(treeNode.data);
            //System.out.println(treeNode.data);
        } else if (level > 1){
            levelOrderTraversal(treeNode.left, level-1);
            levelOrderTraversal(treeNode.right, level-1);
        }
        return list;
    }

    public int _3_get_Height_Of_Binary_Tree(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        else {
            int heightLeft = _3_get_Height_Of_Binary_Tree(treeNode.left);
            int heightRight = _3_get_Height_Of_Binary_Tree(treeNode.right);

            if (heightLeft > heightRight)
                return heightLeft + 1;
            else
                return heightRight + 1;
        }
    }

    public int _3_get_Height_Of_Binary_Tree_by_Iteration(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int height = 0;
        if (treeNode == null)
            return 0;
        while (!queue.isEmpty()){
            int nodeCount = queue.size();

            if (nodeCount == 0)
                return height;

            height++;

            while (nodeCount > 0){
                TreeNode peekedNode = queue.peek();
                queue.poll();
                if (peekedNode.left != null)
                    queue.add(peekedNode.left);
                if (peekedNode.right != null)
                    queue.add(peekedNode.right);

                nodeCount--;
            }
        }

        return height;
    }

    public List<Integer> _1_level_order_traversal_by_queue(TreeNode treeNode){
        ArrayList<Integer> traversalRes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        while (!queue.isEmpty()){
            TreeNode root = queue.poll();

            traversalRes.add(root.data);

            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null){
                queue.add(root.right);
            }
        }
        return traversalRes;
    }

    public Stack<TreeNode> _2_reverse_level_order_traversal(TreeNode treeNode){

        // FIFO
        Queue<TreeNode> queue = new LinkedList<>();
        // LIFO
        Stack<TreeNode> stack = new Stack<>();

        queue.add(treeNode);

        while (!queue.isEmpty()){
            TreeNode root = queue.poll();

            stack.add(root);

            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);

        }

        return stack;

    }
}
