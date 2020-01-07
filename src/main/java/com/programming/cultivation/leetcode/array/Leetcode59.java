package com.programming.cultivation.leetcode.array;

/**
 * @author biyue
 * @since 2020/01/06
 */
public class Leetcode59 {

    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int square = n * n;
        int i = 1;
        int oneDimensional = 0;
        int twoDimensional = 0;
        int[][] result = new int[n][n];
        while (i <= square) {
            result[oneDimensional][twoDimensional] = i;
            if (i < n) {
                twoDimensional++;
            }
            if (i >= n && i <= n - 1) {
                oneDimensional++;
            }


            i++;
        }


    }
}
