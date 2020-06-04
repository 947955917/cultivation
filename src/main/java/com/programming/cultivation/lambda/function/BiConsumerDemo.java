package com.programming.cultivation.lambda.function;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (x,y) -> System.out.println(x + y);

        biConsumer.accept("china","Red");

    }
}
