package com.programming.cultivation.leetcode.array;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode121 {


    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 0;
        int income = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                low = prices[0];
                high = prices[0];
                continue;
            }
            if (prices[i] < low) {
                low = prices[i];
            }
            high = prices[i];
            int diff = high - low;
            income = diff > income ? diff : income;
        }
        return income;
    }
}
