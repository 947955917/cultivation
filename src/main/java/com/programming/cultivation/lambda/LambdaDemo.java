package com.programming.cultivation.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(15, "zhangsan", 68));
        students.add(new Student(14, "lisi", 88));
        students.add(new Student(16, "wangwu", 98));
        students.add(new Student(13, "maliu", 20));
        students.add(new Student(17, "zhaoqi", 59));

//        students.forEach((e)-> System.out.println(e.getScore()));


        students.sort((s1, s2) -> -(s1.getScore() - s2.getScore()));
        students.forEach((s)-> System.out.println(s));


    }


}
