package com.programming.cultivation.leetcode.util;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class ArrayUtil {

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
