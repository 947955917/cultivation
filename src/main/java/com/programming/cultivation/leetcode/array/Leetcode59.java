package com.programming.cultivation.leetcode.array;

import com.programming.cultivation.leetcode.util.ArrayUtil;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode59 {

    public static void main(String[] args) {
        int[][] ints = new Leetcode59().generateMatrix2(4);
        ArrayUtil.print(ints);
        System.out.println();
    }

    public int[][] generateMatrix(int n) {
        // 创建一个n*n的矩阵
        int[][] result = new int[n][n];
        // 通过设定边界，从外层向里层顺序打印
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int total = n * n;
        int num = 1;
        while (num <= total) {
            for (int k = l; k <= r; k++) {
                result[t][k] = num++;
            }
            t++;
            for (int k = t; k <= b; k++) {
                result[k][r] = num++;
            }
            r--;
            for (int k = r; k >= l; k--) {
                result[b][k] = num++;
            }
            b--;
            for (int k = b; k >= t; k--) {
                result[k][l] = num++;
            }
            l++;
        }
        return result;
    }


    public int[][] generateMatrix2(int n) {
        // 创建矩阵
        int[][] matrix = new int[n][n];
        int total = n * n;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;

        while (num <= total) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
        }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }
}
