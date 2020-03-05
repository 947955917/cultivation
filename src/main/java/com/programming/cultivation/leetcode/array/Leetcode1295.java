package com.programming.cultivation.leetcode.array;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1295 {

    /**
     * 算法一
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int[] count = new int[100 * 1000 + 1];
        for (int i : nums) {
            count[i] = count[i] + 1;
        }
        int total = 0;
        for (int i = 10; i <= 99; i++) {
            total += count[i];
        }
        for (int i = 1000; i <= 9999; i++) {
            total += count[i];
        }
        return total;
    }

    public int findNumbers2(int[] nums) {
        int total = 0;
        for (int i : nums) {
            if (i >= 10 && i <= 99) {
                total += 1;
            }
            if (i >= 1000 && i <= 9999) {
                total += 1;
            }
        }
        return total;
    }

}
