package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class App02Test {

    private App02 app02;

    @BeforeEach
    public void before(){
        app02 = new App02();
    }

    @Test
    public void _8_add_1_to_number_represented_as_linkedList(){
        Node list = DsUtils.arrayToLinkedList(1, 2,3);
        Node reverse = list.reverse();
        Node revResult = app02._8_add_1_to_number_represented_as_linkedList(reverse);
        Node res = revResult.reverse();
        System.out.println("Result : "+DsUtils.linkedListAsArray(res));
    }

    @Test
    public void _9_add_two__numbers_represented_as_linkedList(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,4);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3);
        Node res = app02._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }
    @Test
    public void _9_add_two__numbers_represented_as_linkedList_l1_size_greater(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,3,4,5,6,7);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3, 4);
        Node res = app02._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }
    @Test
    public void _9_add_two__numbers_represented_as_linkedList_l2_size_greater(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,3,4);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3,4,5);
        Node res = app02._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }

    @Test
    public void _10_intersection_of_two_sorted_linkedLists(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,9,14, 25, 50);
        Node list2 = DsUtils.arrayToLinkedList(2,8,9,14,50);
        Node res = app02._10_intersection_of_two_sorted_linkedLists(list1, list2);
        System.out.println("Result : "+ DsUtils.linkedListAsArray(res));
    }

    @Test
    public void _linkedListToArray(){
        Node list = DsUtils.arrayToLinkedList(1,2,3);
        System.out.println("List as array : "+DsUtils.linkedListAsArray(list).size());
    }

    @Test
    public void _11_find_intersection_point_of_two_linkedLists(){
        Node list1 = DsUtils.arrayToLinkedList(1, 81, 9, 15, 54, 69, 27, 100, 12, 12);
        System.out.println("List1 : "+DsUtils.linkedListAsArray(list1));
        Node list2 = DsUtils.arrayToLinkedList(17, 18, 29, 24, 5, 11, 64, 62);
        Node common = DsUtils.arrayToLinkedList(65, 89, 35, 64, 42, 95, 18, 92, 31, 14);
        list1.last.next = common;
        list2.last.next = common;
        Node res = app02._11_intersection_point_of_two_linkedLists(list1, list2);
        System.out.println("Result : "+res.data);
    }


    @Test
    public void _12_mergeSort_linkedList(){
        Node list1 = DsUtils.arrayToLinkedList(1, 2 ,3,45,2,7);
        Node res = app02._12_sort_list_using_mergeSort(list1);
        System.out.println("List as array : "+DsUtils.linkedListAsArray(res));
        Node list2 =
                DsUtils.arrayToLinkedList(61 ,91, 95, 42, 27, 36, 91, 4, 2, 53, 92, 82, 21, 16, 18, 95, 47, 26, 71, 38
                        , 69, 12
                        , 67, 99, 35, 94, 3, 11);
        Node res1 = app02._12_sort_list_using_mergeSort(list2);
        System.out.println("List as array : "+DsUtils.linkedListAsArray(res1));
    }
}