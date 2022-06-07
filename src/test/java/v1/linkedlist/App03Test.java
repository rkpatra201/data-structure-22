package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Tag("UnitTest")
class App03Test {

    private App03 app03;

    @BeforeEach
    private void before(){
        app03 = new App03();
    }
    @Test
    void _17_isPalindrome(){
        Node node = DsUtils.arrayToLinkedList(1,2,2,1);
        boolean res = app03._17_check_linkedlist_is_palindrome_1(node);
        boolean res1 = app03._17_check_linkedlist_is_palindrome_2(node);
        Assertions.assertEquals(true,res);
        Assertions.assertEquals(true,res1);
    }

    @Test
    void _18_deletionInCircularList(){
        Node node = DsUtils.arrayToCircularLinkedList(1,2,3,4,5);
        Node node2 = DsUtils.arrayToCircularLinkedList(1,2,3,4,5);
        Node node3 = DsUtils.arrayToCircularLinkedList(1,2,3,4,5);
        Node node1 = DsUtils.arrayToCircularLinkedList(1,2,2,4,5);
        System.out.println("Before deleting 1:"+node.asArray_1());
        Node res1 = app03._18_deletionFromCircularList(node,1);
        System.out.println("After deleting 1:"+res1.asArray_1());
        Node res2 =app03._18_deletionFromCircularList(node2,5);
        System.out.println("After deleting 5:"+res2.asArray_1());
        Node res3 =app03._18_deletionFromCircularList(node3,3);
        System.out.println("After deleting 3:"+res3.asArray_1());
        System.out.println("New LinkedList:"+node1.asArray_1());
        Node res4 = app03._18_deletionFromCircularList(node1,2);
        System.out.println("After deleting 2:"+res4.asArray_1());
    }
    @Test
    void _19_reverseDll(){
        Node node = DsUtils.buildDoubleLinkedList(1,2,3,4,5);
        System.out.println("Before:"+node.asArray());
        Node res = app03._19_reverseDLL(node);
        System.out.println("After:"+res.asArray());
//        Assertions.assertEquals(node.asArray().size(),res.asArray().size());
    }
    @Test
    void _20_FindpairSumInDll(){
        Node node = DsUtils.buildDoubleLinkedList(1,1,2,3,4,5,8);
        int res = app03._20_findPairsOfSum(node , 9);
        Assertions.assertEquals(2,res);
    }
    @Test
    void _15_isCircularLL(){
        Node node = DsUtils.arrayToCircularLinkedList(1,2,3,4,5);
        boolean res = app03._15_isCircular(node);
        Assertions.assertEquals(true,res);
    }
    @Test
    void _21_countTriplets(){
        Node node = DsUtils.buildDoubleLinkedList(1,2,3,4,5);
        Node node1 = DsUtils.buildDoubleLinkedList(1,1,2,3,4,5);
        int res =app03._21_countTriplets(node,6);
        int res1 =app03._21_countTriplets(node1,6);
        Assertions.assertEquals(1,res);
        Assertions.assertEquals(2,res1);

    }
    @Test
    void _16_divideListTwoHalves(){
        Node node = DsUtils.arrayToCircularLinkedList(1,2,2,3,1);
        Node [] heads = app03._16_splitList(node);
        System.out.println("Lists are:");
        for (int i = 0; i <2 ; i++) {
            System.out.println(heads[i].asArray_1());
        }
        Assertions.assertEquals(2,heads.length);
    }
    @Test
    void _22_sortKdll(){
        Node node = DsUtils.buildDoubleLinkedList(3,6,2,12,56,8);
        Node head = app03._22_sortKDll(node,2);
        System.out.println(head.asArray());
        int[] sortArray = new int[]{2,3,6,8,12,56};
        //Assertions.assertEquals(sortArray,head.asArray());
        Node node1 = DsUtils.buildDoubleLinkedList(3,6,2,12,56,8);
        Node head1 = app03._22_sortKDllUsingPQ(node1,2);
        System.out.println(head1.asArray());
       // Assertions.assertEquals(sortArray,head1.asArray());
    }
    @Test
    void _23_rotate(){
        Node node = DsUtils.buildDoubleLinkedList(1,2,3,4,5);
        Node head = app03._23_rotateByNnode(node,2);
        int [] expected = new int[]{3,4,5,1,2};
        System.out.println(head.asArray());
//        List list = Arrays.asList(expected);
//        Assertions.assertEquals(list.toString(),head.asArray());
    }
    @Test
    void _24_reverseInGroup(){
        Node node = DsUtils.buildDoubleLinkedList(1,2,3,4,5,6,7,8,9,10);
        int n = 5;
        Node head = app03._24_rotateInGroup(node , n);
        System.out.println(head.asArray());
    }

}
