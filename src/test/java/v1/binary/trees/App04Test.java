package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class App04Test {

    private App04 app04;

    @BeforeEach
    public void beforeEach() {
        app04 = new App04();
    }

    @Test
    void _01_levelOrderTraversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> values = app04._01_levelOrderTraversal(treeNode);
        System.out.println(values);
    }

    @Test
    void findPathFromRootToNode() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<TreeNode> path = app04.findPathFromRootToNode(treeNode, 80);
        path.stream().forEach(e -> {
            System.out.println(e.data);
        });
    }

    @Test
    void findLowestCommonAncestor() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        TreeNode treeNode1 = app04._30_findLowestCommonAncestor(treeNode, 60, 800);
        if (treeNode1 != null) System.out.println(treeNode1.data);
    }

    @Test
    void _02_reverseLevelOrderTraversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> list = app04._01_levelOrderTraversal(treeNode);
        System.out.println(list);
        list = app04._02_reverseLevelOrderTraversal(treeNode);
        System.out.println(list);
    }

    @Test
    void _03_heightOfTheTree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        int height = app04._03_heightOfTheTree(treeNode);
        treeNode = DsUtils.getDefaultTree();
        int height1 = app04._03_heightOfTheTree_Rec(treeNode);
        System.out.println(height == height1);
    }

    @Test
    void _24_checkMirrorTree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        TreeNode mirrorTree = DsUtils.toMirrorTree(treeNode);
        treeNode = DsUtils.getDefaultTree();
        boolean flag = app04._24_checkMirrorTree(treeNode, mirrorTree);
        System.out.println(flag);
    }

    @Test
    void _12_levelOrderDeQueueZigZagTraversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        app04._12_levelOrderDeQueueZigZagTraversal(treeNode);
    }

    @Test
    void _13_balancedBst() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        System.out.println(app04._13_verifyBalancedBst(treeNode));
    }

    @Test
    void _13_balancedBst_1() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        int x = app04._13_verifyBalancedBst_1(treeNode);
        Assertions.assertTrue(x != -1);
    }

    @Test
    void findAllLeafNodes() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> leafNodes = new ArrayList<>();
        app04.findAllLeafNodes(treeNode, leafNodes);
        System.out.println(leafNodes);
    }

    @Test
    void leftViewOfTree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> result = app04._08_leftViewOfTree(treeNode);
        System.out.println(result);
    }

    @Test
    void rightViewOfTree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        List<Integer> result = app04._09_rightViewOfTree(treeNode);
        System.out.println(result);
    }

    @Test
    void convertToSumTree() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        app04._01_levelOrderTraversal(treeNode);
        System.out.println("======");
        app04._18_convertToSumTree(treeNode);
        app04._01_levelOrderTraversal(treeNode);
    }

    @Test
    void verifySumTree_1() {
        TreeNode root = new TreeNode(44);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(13);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;

        int result = app04._21_verifySumTree(root);
        System.out.println(result);
        Assertions.assertTrue(result != -1);
    }

    @Test
    void verifySumTree_2() {
        TreeNode root = new TreeNode(44);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(13);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(9);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;

        int result = app04._21_verifySumTree(root);
        System.out.println(result);
        Assertions.assertFalse(result != -1);
    }
}