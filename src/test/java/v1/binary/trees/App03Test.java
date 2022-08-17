package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class App03Test {
    private App03 app03;

    @BeforeEach
    private void before() {
        app03 = new App03();
    }

    @Test
    void _00_levelOrderTraversal() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
        TreeNode root = DsUtils.getDefaultTree();
        app03._01_levelOrderTraversal(node);
        app03._01_levelOrderTraversal(root);
    }

    @Test
    void _01_reverseLevelOrderTraversal() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
        TreeNode root = DsUtils.getDefaultTree();
        app03._02_reverselevelOrderTraversal(node);
        app03._02_reverselevelOrderTraversal(root);
    }

    @Test
    void _02_height() {
        TreeNode root = DsUtils.getDefaultTree();
        System.out.println(app03._03_height(root));
        Assertions.assertEquals(3, app03._03_height(root));
        System.out.println(app03._03_height_1(root));
        Assertions.assertEquals(3, app03._03_height_1(root));
    }

    @Test
    void _03_diameter() {
        TreeNode node = DsUtils.buildTree(5, 3, 6, 2, 4);
        //  TreeNode root = DsUtils.getDefaultTree();
        //  Assertions.assertEquals(5, app03._04_diameterOfTree(root));
        Assertions.assertEquals(4, app03._04_diameterOfTree(node));
    }

    @Test
    void _04_mirrorOfTree() {
        TreeNode node = DsUtils.getDefaultTree();
        app03._01_levelOrderTraversal(node);
        System.out.println();
        app03._05_mirrorTree(node);
        app03._01_levelOrderTraversal(node);
    }

    @Test
    void _05_inorderTraversal() {
        TreeNode node = DsUtils.getDefaultTree();
        app03._06_inorderTraversalWithRecurtion(node);
        System.out.println();
        app03._06_inorderTraversalWithoutRecurtion(node);
    }

    @Test
    void _06_preorderTraversal() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._07_preorderTraversalWithRecurtion(root);
        System.out.println();
        app03._07_preorderTraversalWithoutRecurtion(root);
    }

    @Test
    void _07_postorderTraversal() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._08_postorderTraversalWithRecurtion(root);
        System.out.println();
        app03._08_postorderTraversalWithoutRecurtion(root);
    }

    @Test
    void _08_leftView() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._09_leftView_1(root);
        System.out.println();
        app03._09_leftView(root);
    }

    @Test
    void _09_rightView() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._10_rightView(root);
        System.out.println();
        app03._10_rightView_1(root);
    }

    @Test
    void _10_topView() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._11_topView(root);
    }

    @Test
    void _11_bottomView() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._12_bottomView(root);
    }

    @Test
    void _12_zigagView() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._13_zigzagView(root);
    }

    @Test
    void _13_balance() {
        TreeNode root = DsUtils.getDefaultTree();
        Assertions.assertEquals(true, app03._14_isBalance(root));
    }

    @Test
    void _14_printDiagonal() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._15_printDiagonal(root);
    }

    @Test
    void _15_printBoundary() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._16_printBoundary(root);
    }

    @Test
    void _16_ConstructTree() {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = app03._17_constructTree(s);
        app03.printTree(root);
    }

    @Test
    void _17_convertToDll() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._18_convertTreeToDll(root);
    }

    @Test
    void _18_convertToSumTree() {
        TreeNode root = DsUtils.getDefaultTree();
        app03._19_convertingBSTtoSumTree(root);
        app03.printTree(root);
    }

    @Test
    void _19_buildTreeusingPreAndIn() {
        String pre = "ABDECF";
        String In = "DBEAFC";
        HashMap<Character, Integer> map = new HashMap<>();
        TreeNode root = app03._20_mapping(pre, In, map);
        app03.printTree(root);
    }

    @Test
    void _treeAp() {
        TreeNode root = DsUtils.getDefaultTree();
        List<Integer> res = app03.treeAp_1(root);
        System.out.println(res);
    }

    @Test
    void _20_countSwaps() {
        TreeNode root = DsUtils.getDefaultTree();
        app03.inorederTraversal(root);
        app03._20_minSwaps();
    }

    @Test
    void _21_isSumTree() {
        TreeNode root = DsUtils.getDefaultTree();
        boolean res = app03._21_isSumTree(root);
        System.out.println(res);
    }

    @Test
    void _22_checkLeafLevel() {
        TreeNode root = DsUtils.getDefaultTree();
        boolean res = app03._22_checkLeafLevel(root, 0);
        System.out.println(res);
    }

    @Test
    void _23_mirriorTree() {
        TreeNode root1 = DsUtils.getDefaultTree();
        TreeNode root2 = app03._05_mirrorTree(root1);
        root1 = DsUtils.getDefaultTree();
        System.out.println(app03._23_mirriorTree(root1, root2));
    }
}
