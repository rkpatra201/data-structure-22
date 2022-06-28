package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class App01Test {
    private App01 app01;

    @BeforeEach
    public void beforeEach() {
        app01 = new App01();
    }

    //50, 30, 20, 40, 70, 60, 80  - default tree
    @Test
    void _00_level_Order_Traversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
         app01._00_level_Order_Traversal(treeNode);
    }
    @Test
    void _01_reverse_Level_Order_Traversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
         app01._01_reverse_Level_Order_Traversal(treeNode);
    }
    @Test
    void _02_height_Of_Binary_Tree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
         app01._02_height_Of_Binary_Tree(treeNode);
    }
    @Test
    void _03_diameter_Of_Binary_Tree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        int diameter_of_tree = app01._03_diameter_Of_Binary_Tree(treeNode);
        System.out.println("diameter_of_tree : "+diameter_of_tree);
    }
}
