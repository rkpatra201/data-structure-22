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
        Node revResult = new App02()._8_add_1_to_number_represented_as_linkedList(reverse);
        Node res = revResult.reverse();
        System.out.println("Result : "+DsUtils.linkedListAsArray(res));
    }

    @Test
    public void _9_add_two__numbers_represented_as_linkedList(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,4);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3);
        Node res = new App02()._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }
    @Test
    public void _9_add_two__numbers_represented_as_linkedList_l1_size_greater(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,3,4,5,6,7);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3, 4);
        Node res = new App02()._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }
    @Test
    public void _9_add_two__numbers_represented_as_linkedList_l2_size_greater(){
        Node list1 = DsUtils.arrayToLinkedList(1,8,3,4);
        Node list2 = DsUtils.arrayToLinkedList(2,2,3,4,5);
        Node res = new App02()._9_add_two_numbers_represented_as_linkedList(list1, list2);
        Node finalRes = res.reverse();
        System.out.println("Result : "+ DsUtils.linkedListAsArray(finalRes));
    }

    @Test
    public void _linkedListToArray(){
        Node list = DsUtils.arrayToLinkedList(1,2,3);
        System.out.println("List as array : "+DsUtils.linkedListAsArray(list).size());
    }
}