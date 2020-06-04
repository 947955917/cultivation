package com.programming.cultivation.lambda.function;

import com.programming.cultivation.lambda.Student;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Consumer是一个函数式接口，接受一个对象，并处理它，没有返回值。
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Student> consumer = (s) -> {
            System.out.println(s.getName());
            System.out.println(s.getAge());
        };
        consumer.accept(new Student(99,"jack", 80));
    }
}
