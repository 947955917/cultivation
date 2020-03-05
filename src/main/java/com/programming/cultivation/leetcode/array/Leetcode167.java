package com.programming.cultivation.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode167 {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            Integer index = map.get(diff);
            if (index != null) {
                int[] ints = {i + 1, index + 1};
                Arrays.sort(ints);
                return ints;
            }
            map.put(numbers[i], i);
        }
        throw new RuntimeException();
    }

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[k] == diff) {
                    return new int[]{i + 1, k + 1};
                } else if (numbers[k] > diff) {
                    break;
                }
            }
        }
        throw new RuntimeException();
    }

    public int[] twoSum3(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (true) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{++low, ++high};
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }
    }
}
