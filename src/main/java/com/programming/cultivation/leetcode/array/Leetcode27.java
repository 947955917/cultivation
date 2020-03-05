package com.programming.cultivation.leetcode.array;

import com.programming.cultivation.leetcode.util.ArrayUtil;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode27 {

    public static void main(String[] args) {
        int[] arr = new int[]{};
        int i = new Leetcode27().removeElement(arr, 2);
        ArrayUtil.print(arr);
        System.out.println("\n" + i);
    }

    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        if (last < 0) {
            return 0;
        }
        for (int i = 0; i < last; i++) {
            if (nums[i] == val) {
                for (; last > i; last--) {
                    if (nums[last] != val) {
                        int temp = nums[last];
                        nums[last] = val;
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        return nums[last] == val ? last : last + 1;
    }
}
