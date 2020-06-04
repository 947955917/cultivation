package com.programming.cultivation.lambda.why3;

import com.programming.cultivation.lambda.Student;
import com.programming.cultivation.lambda.why.StudentFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaWhy3 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(15, "zhangsan", 68));
        students.add(new Student(14, "lisi", 88));
        students.add(new Student(16, "wangwu", 98));
        students.add(new Student(13, "maliu", 20));
        students.add(new Student(17, "zhaoqi", 59));
        // 查找年龄15岁以上的,60分以上的
//        listByFilter(students, (e) -> e.getAge() <= 15 && e.getScore() > 60);
//        students.forEach(System.out::println);
        students.stream().map(e->e.getName());

    }

}
