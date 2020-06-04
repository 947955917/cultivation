package com.programming.cultivation.lambda;

import lombok.Data;

@Data
public class Student {

    private int age;

    private String name;

    private int score;

    public Student(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }
}
