package com.programming.cultivation.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        Stream<String> stream = strings.stream();
        // 是否并行流
        System.out.println(stream.isParallel());
        // 返回在这个流中元素的个数
        System.out.println(stream.count());
        // 遍历
        // 函数式接口
        strings.stream().forEach(System.out::println);

        // strings.stream().filter()



    }
}
