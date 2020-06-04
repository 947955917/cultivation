package com.programming.cultivation.lambda.why;

import com.programming.cultivation.lambda.Student;

public class AgeFilter implements StudentFilter {

    @Override
    public boolean compare(Student student) {
        return student.getAge() > 15;
    }
}
