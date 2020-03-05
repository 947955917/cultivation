package com.programming.cultivation.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author biyue
 * @since 2020/01/03
 */
public class Leetcode1185 {

    public static void main(String[] args) {
        String week = new Leetcode1185().dayOfTheWeek(3, 1, 2020);
        System.out.println(week);
    }

    public String dayOfTheWeek(int day, int month, int year) {
        // 1970年1月1日是周五
        List<String> strings = Arrays.asList("Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday");
        int[] monthDays = new int[]{31, isLeapyear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 日
        int total = day;
        // 月
        for (int k = 1; k < month; k++) {
            total += monthDays[k - 1];
        }
        // 年
        total += year(year);
        int i = total % 7;
        return strings.get(i);
    }

    public boolean isLeapyear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

    }

    public int year(int year) {
        int total = 0;
        for (int i = 1970; i < year; i++) {
            total += isLeapyear(i) ? 366 : 365;
        }
        return total;
    }

}
