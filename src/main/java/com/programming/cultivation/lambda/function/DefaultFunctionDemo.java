package com.programming.cultivation.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DefaultFunctionDemo {

    public static void main(String[] args) {
        List<String> zimu = Arrays.asList("a", "b", "c");
        Consumer<String> print = (y) -> System.out.println(y);
        zimu.forEach(print);
        zimu.forEach(System.out::println);
    }
}
