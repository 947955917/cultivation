package com.programming.cultivation.lambda.functionref;

import com.programming.cultivation.lambda.Student;

public class NameUtils {

    public static Student init(String s, Integer x) {
        return new Student(x, s, x);
    }

    public static String get(Integer id) {
        return "id:" + id + ",xiaoming...";
    }

    public static void print1(String s) {
        System.out.println(s);
    }

    public static String print3(String s, String b) {
        System.out.println(s);
        System.out.println(b);
        return s;
    }

    public void print2(String s) {
        System.out.println(s);
    }

    public void print4(String s,Integer y) {
        System.out.println(s);
    }

    public NameUtils() {
    }
}
