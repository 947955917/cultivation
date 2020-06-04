package com.programming.cultivation.lambda.why;

import com.programming.cultivation.lambda.Student;

import java.util.ArrayList;
import java.util.List;

public class LambdaWhy {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(15, "zhangsan", 68));
        students.add(new Student(14, "lisi", 88));
        students.add(new Student(16, "wangwu", 98));
        students.add(new Student(13, "maliu", 20));
        students.add(new Student(17, "zhaoqi", 59));
        // 查找年龄15岁以上的
        listByFilter(students, new AgeFilter());

    }

    public static void listByFilter(List<Student> students,StudentFilter filter) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (filter.compare(student)) {
                result.add(student);
            }
        }
        print(result);
    }

    public static void print(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }


}
