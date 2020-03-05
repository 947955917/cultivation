package com.programming.cultivation.jdk.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author biyue
 * @since 2019/12/20
 */
public class IODemo {

    public static void main(String[] args) throws Exception{
        File file = new File("E:\\night\\three\\unicode.txt");
        FileInputStream stream = new FileInputStream(file);

        byte[] data = new byte[90];

        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream,50);
        bufferedInputStream.mark(100);

        bufferedInputStream.read(data);
        System.out.println(new String(data));
        int i = 3;
        while (i-- > 0) {
            data = new byte[1024];
            bufferedInputStream.reset();
            bufferedInputStream.read(data);
            System.out.println(new String(data));
        }

    }
}
