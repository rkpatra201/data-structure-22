package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class App02Test {
    private App02 app02;

    @BeforeEach
    private void before() {
        app02 = new App02();
    }

    @Test
    void _08_add_1_to_number_represented_as_linkedlit(){
        Node node = DsUtils.arrayToLinkedList(99,9,9);
        Node result = app02._08_add_1_to_number_represented_as_linkedlit(node);
        System.out.println("Result : "+result.asArray());

    }
    @Test
    void _09_add_two_numbers_represented_by_linkedlist(){

    }
    @Test
    void _10_intersection_of_two_sorted_linkedlist(){
        Node node1 = DsUtils.arrayToLinkedList(1, 2, 5,8,9,10,11,15,20);
        Node node2 = DsUtils.arrayToLinkedList( 2, 3, 4,8,9,15,55 );
        Node res = app02._10_intersection_of_two_sorted_linkedlist(node1,node2);
        System.out.println(res.asArray());
    }
    @Test
    void _11_intersection_point_of_two_linkedlist(){
        Node node1 = DsUtils.arrayToLinkedList(1, 2, 5,8,9,10);
        Node node2 = DsUtils.arrayToLinkedList( 2, 3, 4,8,9,15,55 );
        int res = app02._11_intersection_point_of_two_linkedlist(node1,node2);
        System.out.println(res);

    }
    @Test
    void _12_merge_sort_for_linkedlist(){
        Node node = DsUtils.arrayToLinkedList(11, 2, 15,88,9,100,111,105,20);
        Node result = app02._12_merge_sort_for_linkedlist(node);
        System.out.println("Result : "+result.asArray());
    }
   @Test
   void _13_quicksort_for_linkedlist(){
       Node node = DsUtils.arrayToLinkedList(11, 2, 15,88,9,100,111,105,20);
       Node result = app02._13_quicksort_for_linkedlist(node);
       System.out.println("Result : "+result.asArray());
   }


    @Test
    void _14_middle_element (){
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5, 0, 9,12);
        Node res = app02._14_middle_element(node);
        System.out.println("result "+ res.data);
    }
    @Test
    void _15_check_circular_linkedlist(){
       Node node = DsUtils.arrayToCircularLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
       boolean res=app02._15_check_circular_linkedlist(node);
        System.out.println("result "+ res);
    }




}
