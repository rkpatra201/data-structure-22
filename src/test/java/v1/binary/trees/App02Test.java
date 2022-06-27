package v1.binary.trees;


import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class App02Test {

    private App02 app02;

    @BeforeEach
    public void beforeEach() {
        app02 = new App02();
    }

    @Test
    public void _1_level_order_traversal(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> res = app02._1_level_order_traversal_by_height_calc(treeNode);
        //System.out.println("Traversal List : "+ res);
        List<Integer> res1 = app02._1_level_order_traversal_by_queue(treeNode);
        System.out.println(res1);
    }

    @Test
    public void _2_reverse_level_order_traversal(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        Stack<TreeNode> res = app02._2_reverse_level_order_traversal(treeNode);
        while (!res.isEmpty())
            System.out.println(res.pop().data);
    }
    @Test
    public void _3_height_of_binary_tree(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        int height = app02._3_get_Height_Of_Binary_Tree(treeNode);
        System.out.println(height);
        int height1 = app02._3_get_Height_Of_Binary_Tree_by_Iteration(treeNode);
        System.out.println(height1);
    }

    @Test
    public void _4_diameter_of_binary_tree(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        int diameter = app02.diameter(treeNode);
        System.out.println(diameter);
//        TreeNode treeNode1 = DsUtils.buildTree(11,22,3,44,55,66,77,8,33);
//        int diameter1 = app02._4_diameter_of_tree(treeNode1);
//        System.out.println(diameter1);
    }

    @Test
    public void _5_mirror_tree(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        TreeNode mirror = app02._5_mirror_of_binary_tree(treeNode);
        System.out.println(mirror);
    }

    @Test
    public void _6_inorder_traversal_binary_tree(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        app02._6_inorder_traversal(treeNode);
    }

    @Test
    public void _7_preOrder_traversal_binary_tree(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        app02._7_preOrder_traversal(treeNode);
    }

    @Test
    public void _8_postOrder_traversal(){
        TreeNode treeNode = DsUtils.getDefaultTree();
        app02._8_postOrder_traversal(treeNode);
    }

}
