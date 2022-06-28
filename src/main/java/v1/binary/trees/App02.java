package v1.binary.trees;

import commons.TreeNode;
import javafx.beans.binding.When;
import sun.reflect.generics.tree.Tree;

import java.util.*;

// Question 11 - 20 both inclusive
public class App02 {
    int diaMeter;
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
    public int diameter(TreeNode root){
        int height = _4_diameter_of_tree(root);
        return diaMeter;
    }


    public int _4_diameter_of_tree(TreeNode treeNode){
        if (treeNode == null)
            return 0;

        int lHeight = _4_diameter_of_tree(treeNode.left);
        int rHeight = _4_diameter_of_tree(treeNode.right);

        diaMeter = Math.max(diaMeter, (lHeight+rHeight+1));
        // height of the tree at present node.
        return Math.max(lHeight,rHeight)+1;
    }

    public TreeNode _5_mirror_of_binary_tree(TreeNode treeNode) {
        if (treeNode == null){
            return null;
        }

        TreeNode mirrorTree = createMirrorTree(treeNode.data);
        mirrorTree.left = _5_mirror_of_binary_tree(treeNode.right);
        mirrorTree.right = _5_mirror_of_binary_tree(treeNode.left);

        return mirrorTree;
    }

    private TreeNode createMirrorTree(int data) {
        TreeNode mirror = new TreeNode();
        mirror.data = data;
        mirror.left = mirror.right = null;
        return mirror;
    }


    public void _6_inorder_traversal(TreeNode treeNode) {
        // inorder -> left -> root -> right
        if (treeNode == null)
            return;

        _6_inorder_traversal(treeNode.left);
        System.out.println(treeNode.data);
        _6_inorder_traversal(treeNode.right);
    }

    public void _7_preOrder_traversal(TreeNode treeNode) {
        if (treeNode == null)
            return;

        System.out.println(treeNode.data);
        _7_preOrder_traversal(treeNode.left);
        _7_preOrder_traversal(treeNode.right);
    }

    public void _8_postOrder_traversal(TreeNode treeNode) {
        if (treeNode == null)
            return;

        _8_postOrder_traversal(treeNode.left);
        _8_postOrder_traversal(treeNode.right);
        System.out.println(treeNode.data);
    }
}
