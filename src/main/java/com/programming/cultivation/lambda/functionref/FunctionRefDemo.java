package com.programming.cultivation.lambda.functionref;

import com.programming.cultivation.lambda.Student;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FunctionRefDemo {

    public static void main(String[] args) {
        // 静态方法引用
        Consumer<String> consumer1 = (string) -> {
            System.out.println(string);
        };
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        Consumer<String> consumer3 = NameUtils::print1;
        Consumer<String> consumer4 = System.out::println;

        // ----------------------------------------------------------
        // 静态方法引用
        System.out.println("----------------------------------------------------------");
        BiFunction<String, Integer, Student> biFunction = (x, y) -> new Student(y, x, y);
        BiFunction<String, Integer, Student> biFunction2 = NameUtils::init;
        System.out.println(biFunction.apply("jack", 33));
        System.out.println(biFunction2.apply("jackson", 23));


        // 实例方法引用

        NameUtils nameUtils = new NameUtils();
        Consumer<String> consumer = nameUtils::print2;



    }
}
