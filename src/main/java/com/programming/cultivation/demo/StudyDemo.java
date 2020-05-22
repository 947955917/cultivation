package com.programming.cultivation.demo;


import java.util.ServiceLoader;

public class StudyDemo {

    public static void main(String[] args) {
        ServiceLoader<Parse> load = ServiceLoader.load(Parse.class);
        for (Parse parse : load) {
            System.out.println(parse.getClass());
            parse.parse();
        }
    }
}
