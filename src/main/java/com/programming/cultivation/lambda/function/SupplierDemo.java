package com.programming.cultivation.lambda.function;

import com.programming.cultivation.lambda.Student;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Student> supplier = () -> init();
        System.out.println(supplier.get());
    }

    private static Student init(){
        Student student = new Student(21,"xiaoming",938);
        return student;
    }
}
