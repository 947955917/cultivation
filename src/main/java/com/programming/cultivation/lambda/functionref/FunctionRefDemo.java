package com.programming.cultivation.lambda.functionref;

import com.google.common.base.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionRefDemo {

    public static void main(String[] args) {
//        System.out.println(NameUtils.get(6));
//        Function<Integer, String> function = NameUtils::get;
//        System.out.println(function.apply(99));

        List<String> stringList = Arrays.asList("a", "b", "c");
        List<String> b = new ArrayList<>();

        stringList.forEach(b::add);

        b.forEach(System.out::println);

//        Consumer<String> consumer5 = (s)->{
//            NameUtils.print(s);
//        };
//        stringList.forEach(System.out::println);
//        Consumer<String> consumer = (s) -> System.out.println(s);
//        Consumer<String> consumer2 = System.out::println;
//        Consumer<String> consumer3 = NameUtils::print;
//        Consumer<String> consumer4 = NameUtils::print2;
//        Consumer<String> consumer6 = NameUtils::print3;

//        stringList.forEach(NameUtils::print1);
//        System.out.println("--------------------------------");
//        stringList.forEach(new NameUtils()::print2);
//
//        Supplier<NameUtils> aNew = NameUtils::new;



    }
}
