package com.programming.cultivation.leetcode.array;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1287 {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        int specialInteger = new Leetcode1287().findSpecialInteger2(arr);
        System.out.println(specialInteger);
    }


    /**
     * 1 <= arr.length <= 10^4
     * 0 <= arr[i] <= 10^5
     *
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        int[] count = new int[100001];
        int threshold = arr.length / 4;
        for (int i : arr) {
            count[i]++;
            if (count[i] > threshold) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public int findSpecialInteger2(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int count = 1;
        int k = arr[0];
        int threshold = arr.length / 4;
        for (int i = 1; i < arr.length; i++) {
            if (k == arr[i]) {
                count++;
            } else {
                k = arr[i];
                count = 1;
            }
            if (count > threshold) {
                return k;
            }
        }
        throw new RuntimeException();
    }

    public int findSpecialInteger3(int[] arr) {
        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }
        return arr[0];
    }
}
