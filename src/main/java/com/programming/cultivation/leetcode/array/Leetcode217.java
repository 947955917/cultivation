package com.programming.cultivation.leetcode.array;

import java.util.Arrays;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
