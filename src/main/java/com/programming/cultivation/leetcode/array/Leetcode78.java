package com.programming.cultivation.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author biyue
 * @since 2020/01/14
 */
public class Leetcode78 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
//        List<List<Integer>> subsets0 = subsets(ints, 0, 0);
//        List<List<Integer>> subsets0 = subsets(ints, 0, 1);
//        List<List<Integer>> subsets1 = subsets(ints, 1, 2);
//        List<List<Integer>> subsets2 = subsets(ints, 2, 3);
        List<List<Integer>> subsets = subsets(ints);

        System.out.println();


    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 默认加空集
        result.add(new ArrayList<>());
        for (int size = 0; size <= nums.length; size++) {
            int end = 0;
            for (int start = 0; end < nums.length; start++) {
                end = start + size;
                List<List<Integer>> subsets = subsets(nums, start, end);
                result.addAll(subsets);
                if (size == 0) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param nums  原数据数组
     * @param start 开始数组下标
     * @param end   结束数组下标，不包含
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums, int start, int end) {
        List<List<Integer>> subsets = new ArrayList<>();
        // 基础数组
        List<Integer> baseList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            baseList.add(nums[i]);
        }
        // 生成子集
        for (int i = end; i < nums.length; i++) {
            List<Integer> item = new ArrayList<>(baseList);
            item.add(nums[i]);
            subsets.add(item);
        }
        return subsets;
    }

}
