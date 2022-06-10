package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
class App04Test {

    private App04 app04;

    @BeforeEach
    private void before() {
        app04 = new App04();
    }

//    @Test
//    void _27_flatten_A_LinkedList() {
//        Node list1 = DsUtils.arrayToLinkedList(1, 5, 11, 15, 21, 25);
//        Node list2 = DsUtils.arrayToLinkedList(2, 5, 22, 26, 31, 35);
//        Node list3 = DsUtils.arrayToLinkedList(3, 4, 13, 16, 33, 35);
//        Node list4 = DsUtils.arrayToLinkedList(5, 7, 11, 16);
//
//        list1.right = list2;
//        list2.right = list3;
//        list3.right = list4;
//        app04._27_flatten_A_LinkedList(list1);
//    }
//
//    @Test
//    void reverseLinkedList() {
//        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5);
//        Node reverse = node.reverse();
//        System.out.println("reverse: " + reverse.asArray());
//    }
//
//    @Test
//    void _28_sort_LinkedList_With_0_1_2() {
//        Node node = DsUtils.arrayToLinkedList(2, 1, 1, 0, 2, 2, 0, 1, 0, 1, 0, 0, 2, 2);
//        int len = node.asArray().size();
//        Node result = app04._28_sort_LinkedList_With_0_1_2(node);
//        System.out.println("result: " + result.asArray());
//        Assertions.assertEquals(len, result.asArray().size());
//    }
//
//    @Test
//    void _buildDoubleLinkedList() {
//        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3);
//        System.out.println(node.asArray());
//    }
//
//    @Test
//    void _34_find_NthNode_FromEnd() {
//        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5, 6, 7);
//        Node result = app04._34_find_NthNode_FromEnd(node, 3);
//        System.out.println("node from end location: " + result.data);
//    }
//
//    @Test
//    void _33_segregate_even_odd_linked_list() {
//        Node node = DsUtils.arrayToLinkedList(1, 2, 2, 3, 4, 5, 6, 6, 7);
//        Node result = app04._33_segregate_even_odd_linked_list(node);
//        System.out.println("result: " + result.asArray());
//    }
//
//
//    @Test
//    void _33_segregate_even_odd_linked_list_1() {
//        Node node = DsUtils.arrayToLinkedList(1, 2, 2, 3, 4, 5, 6, 6, 7);
//        Node result = app04._33_segregate_even_odd_linked_list_1(node);
//        System.out.println("result: " + result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_1() { // node1.data == node2.data
//        Node node2 = DsUtils.arrayToLinkedList(1, 2, 3, 4);
//        Node node1 = DsUtils.arrayToLinkedList(1, 4, 5, 6);
//        Node result = app04._30_merge_LinkedList_And_Sort(node1, node2);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_2() { // node2.data > node1.data
//        Node node2 = DsUtils.arrayToLinkedList(1, 2, 3, 4);
//        Node node1 = DsUtils.arrayToLinkedList(3, 4, 5, 6);
//        Node result = app04._30_merge_LinkedList_And_Sort(node1, node2);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_3() { // node1.data < node2.data
//        Node node1 = DsUtils.arrayToLinkedList(1, 2, 3, 4);
//        Node node2 = DsUtils.arrayToLinkedList(3, 4, 5, 6);
//        Node result = app04._30_merge_LinkedList_And_Sort(node1, node2);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_4() { // node1 is large in size
//        Node node1 = DsUtils.arrayToLinkedList(1, 2, 3, 3);
//        Node node2 = DsUtils.arrayToLinkedList(4, 5, 6);
//        Node result = app04._30_merge_LinkedList_And_Sort(node1, node2);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_5() { // node2 is large in size
//        Node node1 = DsUtils.arrayToLinkedList(1, 2, 3);
//        Node node2 = DsUtils.arrayToLinkedList(4, 5, 6,7);
//        Node result = app04._30_merge_LinkedList_And_Sort(node1, node2);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void _x_merge_LinkedList_And_Sort_6() { // one of the node is null
//        Node node1 = DsUtils.arrayToLinkedList(1, 2, 3);
//        Node node2 = DsUtils.arrayToLinkedList(4, 5, 6,7);
//        Node result = app04._30_merge_LinkedList_And_Sort(null, node2);
//        System.out.println("result: "+result.asArray());
//        result = app04._30_merge_LinkedList_And_Sort(node1, null);
//        System.out.println("result: "+result.asArray());
//    }
//
//    @Test
//    void testCircularLinkedList()
//    {
//        Node node = DsUtils.arrayToCircularLinkedList(1,2,3);
//        System.out.println("result: "+node.asArray());
//    }


}