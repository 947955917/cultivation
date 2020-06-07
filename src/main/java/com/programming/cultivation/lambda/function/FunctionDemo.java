package com.programming.cultivation.lambda.function;

import com.programming.cultivation.lambda.Student;

import java.util.function.Function;

/**
 * Function 代表一个函数，接受一个输入，返回一个输出
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<Student, String> function = (s) -> s.getName();
        Function<Student, String> function1 = s -> s.getName();
        Student student = new Student();


        System.out.println(function.apply(new Student(11, "tom", 99)));
    }
}
