package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class App03Test {
    private App03 app03;

    @BeforeEach
    private void before() {
        app03 = new App03();
    }

    @Test
    void _01_levelOrderTraversal() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
        TreeNode root = DsUtils.getDefaultTree();
        app03._01_levelOrderTraversal(node);
        app03._01_levelOrderTraversal(root);
    }

    @Test
    void _02_reverseLevelOrderTraversal() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
        TreeNode root = DsUtils.getDefaultTree();
        app03._02_reverselevelOrderTraversal(node);
        app03._02_reverselevelOrderTraversal(root);
    }

    @Test
    void _03_height() {
        TreeNode root = DsUtils.getDefaultTree();
        System.out.println(app03._03_height(root));
        Assertions.assertEquals(3,app03._03_height(root));
        System.out.println(app03._03_height_1(root));
        Assertions.assertEquals(3,app03._03_height_1(root));
    }

    @Test
    void _04_diameter() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
      //  TreeNode root = DsUtils.getDefaultTree();
      //  Assertions.assertEquals(5, app03._04_diameterOfTree(root));
        Assertions.assertEquals(4, app03._04_diameterOfTree(node));
    }
    @Test
    void _05_mirrorOfTree(){
        TreeNode node = DsUtils.getDefaultTree();
        app03._01_levelOrderTraversal(node);
        System.out.println();
        app03._05_mirrorTree(node);
        app03._01_levelOrderTraversal(node);
    }
    @Test
    void _06_inorderTraversal(){
        TreeNode node = DsUtils.getDefaultTree();
        app03._06_inorderTraversalWithRecurtion(node);
        System.out.println();
        app03._06_inorderTraversalWithoutRecurtion(node);
    }
    @Test
    void _07_preorderTraversal(){
        TreeNode root = DsUtils.getDefaultTree();
        app03._07_preorderTraversalWithRecurtion(root);
        System.out.println();
        app03._07_preorderTraversalWithoutRecurtion(root);
    }
    @Test
    void _08_postorderTraversal(){
        TreeNode root = DsUtils.getDefaultTree();
        app03._08_postorderTraversalWithRecurtion(root);
        System.out.println();
        app03._08_postorderTraversalWithoutRecurtion(root);
    }
}
