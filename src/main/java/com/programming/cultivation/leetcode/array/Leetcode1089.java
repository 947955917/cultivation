package com.programming.cultivation.leetcode.array;

import java.util.Arrays;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1089 {

    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            temp[i++] = arr[j];
            if (arr[j] == 0) {
                if (i == arr.length) {
                    break;
                }
                temp[i++] = arr[j];
            }
            j++;
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = temp[k];
        }
    }

    public void duplicateZeros2(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0, k = 0; i < arr.length && k < arr.length; i++, k++) {
            if (temp[i] == 0 && k < arr.length - 1) {
                arr[k] = temp[i];
                k++;
                arr[k] = 0;
            } else {
                arr[k] = temp[i];
            }
        }
    }
}
