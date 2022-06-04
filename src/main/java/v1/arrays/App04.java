package v1.arrays;

import java.util.Arrays;

// 25-35
public class App04 {

    /**
     * buy - sell (25)
     * max profit in one transaction
     * max profit in infinite transaction
     * max profit in infinite transaction with fee
     * max profit in at most 2 transaction
     * max profit with cooldown
     * max profit with k transactions
     *
     * @param arr
     * @return
     */
    // buy - sell one transaction (important)
    public int _25_maxProfit_stock_1(int... arr) {
        return maxDiff_Small_Before_Large(arr);
    }

    // buy - sell any number of transaction
    public int _25_maxProfit_stock_2(int... arr) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - arr[i - 1];
            maxProfit = maxProfit + Math.max(profit, 0); // whenever profit is positive, sell it
        }
        return maxProfit;
    }

    // buy - sell any number of transaction
    public int _25_maxProfit_stock_2_1(int... arr) {
        return _25_maxProfit_stock_3(0, arr);
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/2075006/C%2B%2B-oror-100-oror-DP-Method-oror-Easy-with-Explanation

    // max profit in infinite transaction with fee
    public int _25_maxProfit_stock_3_1(int fee, int... prices) {
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - buy - fee);
            buy = Math.min(buy, prices[i] - profit); // use profit to buy stock: effectiveBuy
        }
        return profit;
    }

    public int _25_maxProfit_stock_3(int fee, int... prices) {
        return _25_maxProfit_stock_3_1(fee, prices);
    }

    public int maxDiff_Small_Before_Large(int... arr) {
        int maxDiff = -1;
        int minSoFar = arr[0];
        // find min element and update it for every index if the new value is smaller than current value
        // currentMaxDiff = current - minSoFar
        // maxDiffSoFar = max(currentMaxDiff, maxDiff);
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            if (currentValue < minSoFar) {
                minSoFar = arr[i];
            }
            int currentMaxDiff = currentValue - minSoFar;
            maxDiff = Math.max(currentMaxDiff, maxDiff);
        }
        return maxDiff;
    }
}
