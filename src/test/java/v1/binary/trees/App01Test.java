package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class App01Test {

    private App01 app01;

    @BeforeEach
    public void beforeEach() {
        app01 = new App01();
    }

    @Test
    void _01_levelOrderTraversal() {
        TreeNode treeNode = DsUtils.getDefaultTree();
        app01._01_levelOrderTraversal(treeNode);

}
}
