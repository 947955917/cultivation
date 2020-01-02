package com.programming.cultivation.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author biyue
 * @since 2020/01/02
 */
public class Leetcode1 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        int[] ints = new Leetcode1().twoSum(nums, target);
        if (ints != null) {
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        }
    }

    /**
     * 两边hash表算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length << 1);
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int a = nums[j];
            int b = target - a;
            Integer index = numMap.get(b);
            if (index != null && index != j) {
                return new int[]{j, index};
            }
        }
        return null;
    }

    /**
     * 一遍hash算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length << 1);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            Integer index = numMap.get(b);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
            numMap.put(a, i);
        }
        return null;
    }


}
