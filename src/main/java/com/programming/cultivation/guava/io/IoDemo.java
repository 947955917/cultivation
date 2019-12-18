package com.programming.cultivation.guava.io;


import com.google.common.io.ByteSource;
import com.google.common.io.Files;

import java.io.File;

/**
 * @author biyue
 * @since 2019/12/18
 */
public class IoDemo {

    public static void main(String[] args) throws Exception {
        ByteSource byteSource = Files.asByteSource(new File("E:\\1.txt"));

    }
}
