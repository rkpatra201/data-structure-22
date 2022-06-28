package v1.binary.trees;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Question 0 - 10 both inclusive
public class App01 {
    public void _01_levelOrderTraversal(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode t= queue.poll();
            System.out.print(t.data +" , ");
            if(t.left !=null){
                queue.add(t.left);
            }

            if(t.right!=null){
                queue.add(t.right);

            }

        }

    }
}
