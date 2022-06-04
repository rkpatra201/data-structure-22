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
    private void before01() {
        app01 = new App01();
    }

    @Test
    void  _01_Reverse_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5);
        Node reverse = app01._01_Reverse_LinkedList(node);
        System.out.println("reverse linked list: " +reverse.asArray());

    }

    @Test
    void  _02_Reverse_LinkedList_In_A_Group(){
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5,6,7,8,9,10);
        Node reverse = app01._02_Reverse_LinkedList_In_A_Group(node,4);
        System.out.println("reverse linked list in a group: " +reverse.asArray());

    }
    @Test
    void  _03_Detect_Loop_In_A_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(1,3,4);
        if( app01._03_Detect_Loop_In_A_LinkedList(node))
            System.out.println("Loop Found...");
        else
            System.out.println("Loop Not Found...");


    }
    @Test
    void _04_Detect_And_Remove_Loop_In_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(50,20,15,4,10);
        int result = app01._04_Detect_And_Remove_Loop_In_LinkedList(node);
        System.out.println("Result: " +result);
    }
    @Test
    void _05_Find_First_Node_Of_Loop_In_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(50,20,15,4,10);
        Node result = app01._05_Find_First_Node_Of_Loop_In_LinkedList(node);
        System.out.println("Result: " +result);
    }
    @Test
    void _06_Remove_Duplicates_From_Sorted_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(1,1,2,3,3,3,4,4,4,4,9,1,9);
        app01._06_Remove_Duplicates_From_Sorted_LinkedList(node);
        System.out.println("Result : " + node.asArray());
    }
    @Test
    void _07_Remove_Duplicates_From_Un_Sorted_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(55,90,90,34,55,90,1,90,2,90);
        app01._07_Remove_Duplicates_From_Un_Sorted_LinkedList(node);
        System.out.println("Result : " + node.asArray());
    }
    @Test
    void _08_Move_Last_Element_To_From_Of_LinkedList(){
        Node node = DsUtils.arrayToLinkedList(1,2,3,4,5);
        app01._08_Move_Last_Element_To_From_Of_LinkedList(node);
        System.out.println("Result : " + node.asArray());
    }
}
