package com.programming.cultivation.leetcode.array;

import com.programming.cultivation.leetcode.util.ArrayUtil;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1304 {

    public static void main(String[] args) {
        int[] ints = new Leetcode1304().sumZero(6);
        ArrayUtil.print(ints);
    }

    /**
     * 1 <= n <= 1000
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        int[] result = new int[n];
        int k = n / 2;
        for (int i = 0; i < k; i++) {
            int j = i + 1;
            result[i] = j;
            result[i + k] = -j;
        }
        return result;
    }
}
