package v1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import v1.arrays.App04;

class App04Test {

    private App04 app04;

    @BeforeEach
    public void before() {
        app04 = new App04();
    }

    @Test
    void _25_maxProfit_stock_1() {
        int[] arr = {10, 2, 9, 8, 1, 5, 6, 18, 3, 4, 25};
        int result = app04._25_maxProfit_stock_1(arr);
        System.out.println(result);
    }

    @Test
    void _25_maxProfit_stock_2() {
        int[] arr = {100, 180, 260, 310,
                40, 535, 695};
        int result = app04._25_maxProfit_stock_3(0,arr);
        System.out.println(result);
    }

    @Test
    void _25_maxProfit_stock_2_1() {
        // v(20), p(40), v(30), p(60), v(60), p(70)
        // 60 is considered twice as infinite transactions allowed
        // 20 + 30 + 10 = 20 + 40 = 60
        int[] arr = {20, 40, 30, 60, 70};
        int result = app04._25_maxProfit_stock_3(0,arr);
        System.out.println(result);
    }

    @Test
    void _25_maxProfit_stock_3() {
        int[] arr = {7, 1, 5, 3, 6, 4}; //{6, 1, 7, 2, 8, 4}; //{1, 3, 2, 8, 4, 9};
        int fee = 1;
        int result = app04._25_maxProfit_stock_3(fee, arr);
        Assertions.assertEquals(result, 5);
    }

    @Test
    void _25_maxProfit_stock_3_1() {
        int[] arr = {6, 1, 7, 2, 8, 4}; //{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = app04._25_maxProfit_stock_3(fee, arr);
        Assertions.assertEquals(result, 8);
    }

    @Test
    void _25_maxProfit_stock_3_2() {
        int[] arr = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = app04._25_maxProfit_stock_3(fee, arr);
        Assertions.assertEquals(result, 8);
    }

    @Test
    void _25_maxProfit_stock_3_3() {
        int[] arr = {10, 20, 30};
        int fee = 2;
        int result = app04._25_maxProfit_stock_3(fee, arr);
        Assertions.assertEquals(result, 18);
    }
}