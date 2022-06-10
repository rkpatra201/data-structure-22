package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class App01Test {
    private App01 app01;

    @BeforeEach
    private void before() {
        app01 = new App01();
    }

    @Test
    void _00_reverse_linkedlist() {
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5);
        Node result = app01._00_reverse_linkedlist(node);
        System.out.println("result: " + result.asArray());
    }

    @Test
    void _01_reverse_linkedlist_in_a_group_of_given_size() {
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res = app01._01_reverse_linkedlist_in_a_group_of_given_size(node, 3);
        System.out.println("result : " + res.asArray());
    }

    @Test
    void _02_detect_loop_in_a_linkedlist() {
        Node node = DsUtils.arrayToCircularLinkedList(1, 2, 3, 4, 5, 0, 9, 8 );
        boolean res = app01._02_detect_loop_in_a_linkedlist(node);
        System.out.println("result " + res);
    }
    @Test
    void _03_deleteloop(){
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res= app01._03_deleteloop(node);
        System.out.println("result" + res.asArray());
    }
    @Test
     void _04_firstnode_of_loop() {
        Node node = DsUtils.arrayToCircularLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res = app01._04_firstnode_of_loop(node);
        System.out.println("result :" + res.data);
    }
    @Test
    void  _05_remove_duplicates_in_a_sorted_linkedlist (){
        Node node = DsUtils.arrayToLinkedList(1, 2,2,3, 3, 4, 5);
//        Node node = DsUtils.arrayToLinkedList(1, 2,2,3, 3, 4, 5,1,2);  //it will not remove the duplicate if it is not present  in a sorted order
        Node res = app01._05_remove_duplicates_in_a_sorted_linkedlist(node);
        System.out.println("result"+ res.asArray());
    }
    @Test
    void  _06_remove_duplicates_in_a_unsorted_linkedlist (){
        Node node = DsUtils.arrayToLinkedList(1, 2,2,3,3,4, 5, 0, 9, 8);
        app01._06_remove_duplicates_in_a_unsorted_linkedlist(node);
        System.out.println("result "+ node.asArray());
    }

    @Test
    void  _07_moveToFront(){
        Node node = DsUtils.arrayToLinkedList(1, 2,2,3,3,4, 5, 0, 9, 8);
        Node result = app01._07_moveToFront(node);
        System.out.println("result :"+result.asArray());
    }

}








