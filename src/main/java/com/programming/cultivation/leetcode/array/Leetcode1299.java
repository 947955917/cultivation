package com.programming.cultivation.leetcode.array;

import com.programming.cultivation.leetcode.util.ArrayUtil;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1299 {

    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 7, 4, 6, 5};
        int[] ints = new Leetcode1299().replaceElements(arr);
        ArrayUtil.print(ints);
    }
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;
        int max = arr[arr.length-1];
        for(int i = arr.length -2 ;i>=0 ; i--){
            if (max >= arr[i]) {
                result[i] = max;
            } else {
                int temp = arr[i];
                result[i] = max;
                max = temp;
            }
        }
        return result;
    }

}
