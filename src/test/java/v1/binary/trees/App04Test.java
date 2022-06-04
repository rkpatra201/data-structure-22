package v1.binary.trees;

import commons.DsUtils;
import commons.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}