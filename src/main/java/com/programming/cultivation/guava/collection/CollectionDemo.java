package com.programming.cultivation.guava.collection;

import com.google.common.collect.ImmutableList;

/**
 * @author biyue
 * @since 2019/12/18
 */
public class CollectionDemo {

    public static void main(String[] args) {
        ImmutableList<String> immutableList = ImmutableList.of("A","B");
        immutableList.get(5);
    }
}
