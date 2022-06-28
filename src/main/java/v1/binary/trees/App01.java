package v1.binary.trees;

import commons.Node;
import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Question 0 - 10 both inclusive
public class App01 {
//    public  void  _00_level_Order_Traversal(TreeNode treeNode){   // order = O(n^2)
//        int level = _02_height_Of_Binary_Tree(treeNode);
//        for (int i=1;i<=level;i++){
//            traverse(treeNode,i);
//        }
//    }
    public  void  _00_level_Order_Traversal(TreeNode treeNode) {   //Order = O(n)
        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);
        while (!q.isEmpty()){
            TreeNode current = q.poll();
            System.out.print(current.data+ ", ");
            if(current.left != null){
                q.add(current.left);
            }
            if (current.right != null){
                q.add(current.right);
            }
        }

    }


        void traverse(TreeNode treeNode , int level){
        if(treeNode == null)
            return;
        if(level == 1)
            System.out.print(treeNode.data + ", ");
        else {
            traverse(treeNode.left,level-1);
            traverse(treeNode.right,level-1);
        }
    }

    public void _01_reverse_Level_Order_Traversal(TreeNode treeNode){
        int level = _02_height_Of_Binary_Tree(treeNode);
        for (int i=level;i>=1;i--){
            traverse(treeNode,i);
        }
    }
    public int _02_height_Of_Binary_Tree(TreeNode treeNode){

        if(treeNode == null)
            return 0;
        else{
            return Math.max(_02_height_Of_Binary_Tree(treeNode.left),_02_height_Of_Binary_Tree(treeNode.right))+1;
        }
    }

//    50, 30, 20, 40, 70, 60, 80
//
    int diameter = Integer.MIN_VALUE;
    public int _03_diameter_Of_Binary_Tree(TreeNode treeNode){
        App01 app01 = new App01();
        if (treeNode == null)
            return 0;
        int height_of_tree = _height_Of_Binary_Tree(treeNode,app01);
        return app01.diameter;
    }
    public int _height_Of_Binary_Tree(TreeNode treeNode, App01 app01){
        if(treeNode == null)
            return 0;
        else{
            app01.diameter=Math.max(app01.diameter, 1+_height_Of_Binary_Tree(treeNode.left,app01)+
                    _height_Of_Binary_Tree(treeNode.right,app01));
            return Math.max(_height_Of_Binary_Tree(treeNode.left,app01),
                    _height_Of_Binary_Tree(treeNode.right,app01))+1;
        }
    }

}
