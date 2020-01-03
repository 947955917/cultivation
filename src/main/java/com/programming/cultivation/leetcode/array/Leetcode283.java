package com.programming.cultivation.leetcode.array;

import com.programming.cultivation.leetcode.util.ArrayUtil;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new Leetcode283().moveZeroes(nums);
        ArrayUtil.print(nums);
    }

    /**
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = -1;
        int fast = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 0) {
                if (slow == -1) {
                    slow = i;
                }
            } else {
                if (slow != -1) {
                    nums[slow] = nums[fast];
                    nums[fast] =0;
                    slow++;
                }
            }
            fast++;
        }
    }


}
