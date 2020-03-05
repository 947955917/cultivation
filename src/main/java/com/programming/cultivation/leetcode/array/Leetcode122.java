package com.programming.cultivation.leetcode.array;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode122 {


    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i - 1];
            difference = difference > 0 ? difference : 0;
            total += difference;
        }
        return total;
    }
}
