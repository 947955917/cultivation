package com.programming.cultivation.lambda.why;

import com.programming.cultivation.lambda.Student;

@FunctionalInterface
public interface StudentFilter {

    boolean compare(Student student);
}
