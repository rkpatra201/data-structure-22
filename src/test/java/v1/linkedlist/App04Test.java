package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("UnitTest")
class App04Test {

    private App04 app04;

    @BeforeEach
    private void before() {
        app04 = new App04();
    }

    @Test
    void _27_flatten_A_LinkedList() {
        Node list1 = DsUtils.arrayToLinkedList(1, 5, 11, 15, 21, 25);
        Node list2 = DsUtils.arrayToLinkedList(2, 5, 22, 26, 31, 35);
        Node list3 = DsUtils.arrayToLinkedList(3, 4, 13, 16, 33, 35);
        Node list4 = DsUtils.arrayToLinkedList(5, 7, 11, 16);

        list1.right = list2;
        list2.right = list3;
        list3.right = list4;
        app04._27_flatten_A_LinkedList(list1);
    }
}