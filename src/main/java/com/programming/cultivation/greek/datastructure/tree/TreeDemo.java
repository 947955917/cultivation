package com.programming.cultivation.greek.datastructure.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author biyue
 * @since 2020/01/15
 */
public class TreeDemo {

    public static void main(String[] args) {
        Map<TreeDemo, Integer> map = new TreeMap<>();
//        map.put(1, 1);
//        map.put(2, 2);
        map.put(new TreeDemo(), 1);
        map.put(new TreeDemo(), 2);


    }

}
