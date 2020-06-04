package com.programming.cultivation.lambda.functionref;

public class NameUtils {

    public static String get(Integer id) {
        return "id:" + id + ",xiaoming...";
    }

    public static void print1(String s){
        System.out.println(s);
    }

    public static String print3(String s,String b){
        System.out.println(s);
        System.out.println(b);
        return s;
    }

    public void print2(String s){
        System.out.println(s);
    }

    public NameUtils() {
    }
}
