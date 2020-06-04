package com.programming.cultivation.lambda.mine;

import java.util.function.BiConsumer;

public class CalcDemo {

    public static void main(String[] args) {
//        Calc add = (apple, y) -> apple + y;
//        System.out.println(add.calc(59, 484));
//        System.out.println("--------------------------------");
//        Calc sub = (x, y) -> x - y;
//        System.out.println(sub.calc(56, 484));
//        System.out.println("--------------------------------");
//        Calc calc = new Calc() {
//            @Override
//            public int calc(int a, int b) {
//                return a + b;
//            }
//        };
//        System.out.println(calc.calc(2, 9));
//
//        Calc calc1 = (apple, banana) -> {
//            return apple + banana;
//        };
//        System.out.println(calc1.calc(2, 9));

        Calc calc2 = (x, y) -> {
            BiConsumer<Integer, Integer> biConsumer = (a, b) -> {
                System.out.println(a * b);
            };
            biConsumer.accept(x,y);
            return 11;
        };
        System.out.println(calc2.calc(2, 9));
    }
}
