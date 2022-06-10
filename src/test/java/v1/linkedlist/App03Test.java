package v1.linkedlist;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Test;

import commons.DsUtils;
import commons.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class App03Test {
    private App03 app03;

    @BeforeEach
    private void before() {
        app03 = new App03();
    }

    @Test
    void _16_spilt_circular_linkedlist(){
        Node node = DsUtils.arrayToCircularLinkedList(1, 2, 3, 4, 5, 9, 8);
        app03._16_spilt_circular_linkedlist(node);
    }
    @Test
    void  _17_check_if_the_linkedlist_is_palindrome(){
        Node node = DsUtils.arrayToLinkedList(1, 2, 3, 4, 5, 9, 8);
        boolean result = app03._17_check_if_the_linkedlist_is_palindrome(node);
        System.out.println("result :"+ result);

    }

    @Test
    void  _18_deletion_from_a_circular_linkedlist(){
        Node node = DsUtils.arrayToCircularLinkedList(1, 2, 3, 4, 5, 9, 8);
        Node result = app03._18_deletion_from_a_circular_linkedlist(node,2);
        System.out.println("result :"+result.asArray());
    }

    @Test
    void _19_reversedll(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res= app03._19_reversedll(node);
        System.out.println("result " + res.asArray());
    }
    @Test
    void _20_find_pair_with_given_sum_in_doubly_linkedlist(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5,  9,11,12);
        System.out.println("given sum = 6");
        app03._20_find_pair_with_given_sum_in_doubly_linkedlist(node,6);
        System.out.println("given sum = 15");
        app03._20_find_pair_with_given_sum_in_doubly_linkedlist_in_naive_algo(node,15);
  }
    @Test
    void _21_count_triplets_in_a_shorted_doubly_linkedlist(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5, 8);
        int res= app03._21_count_triplets_in_a_shorted_doubly_linkedlist(node,10);
        System.out.println("result " + res);
    } @Test
    void _22_sort_a_k_sorted_doubly_linkedlist(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res= app03._22_sort_a_k_sorted_doubly_linkedlist(node);
        System.out.println("result " + res.asArray());
    } @Test
    void _23_rotate_double_linkedlist_by_n_nodes(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res= app03._23_rotate_double_linkedlist_by_n_nodes(node);
        System.out.println("result " + res.asArray());
    } @Test
    void _24_rotate_double_linkedlist_in_a_group_of_given_size(){
        Node node = DsUtils.buildDoubleLinkedList(1, 2, 3, 4, 5, 0, 9, 8);
        Node res= app03._24_rotate_double_linkedlist_in_a_group_of_given_size(node);
        System.out.println("result " + res.asArray());
    }

}
