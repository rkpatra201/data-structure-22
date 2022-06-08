package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
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
        System.out.println(app04._13_balancedBst(treeNode));
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
}