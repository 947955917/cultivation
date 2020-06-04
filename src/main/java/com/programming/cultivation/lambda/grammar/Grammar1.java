package com.programming.cultivation.lambda.grammar;

import java.util.concurrent.Callable;

public class Grammar1 {

    public static void main(String[] args) throws Exception {
        // 非lambda语法
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1.........");
            }
        };
        runnable1.run();
        // lambda语法，大括号相当于一个作用域，写复杂代码逻辑时可以这样写
        Runnable runnable2 = () -> {
            System.out.println("runnable2.........");
            System.out.println("runnable2.........");
            System.out.println("runnable2.........");
            System.out.println("runnable2.........");
        };
        runnable2.run();
        // lambda语法
        Runnable runnable3 = () -> System.out.println("runnable3.........");
        runnable3.run();

        System.out.println("----------------------------------------------------");
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable1...........";
            }
        };
        System.out.println(callable1.call());

        Callable<String> callable2 = () -> {
            System.out.println("print callable2........");
            return "callable2...........";
        };
        System.out.println(callable2.call());

        Callable<String> callable3 = () -> "callable3.........";
        System.out.println(callable3.call());

    }
}
