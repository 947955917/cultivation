package com.programming.cultivation.match.match001;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author biyue
 * @since 2019/12/19
 */
public class MatchDemo {

    private static final String FROM_PATH = "E:\\night\\three";
    private static final String TO_PATH = "E:\\night\\four";
    private static final String PREFIX = "copy_";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        File file = new File(FROM_PATH);
        File[] files = file.listFiles();
        for (File from : files) {
            // 1MB
            int size = 1024 * 8;
            byte[] buffer = new byte[size];
            FileOutputStream fileOutputStream = new FileOutputStream(TO_PATH + File.separator + PREFIX + from.getName());
            FileInputStream fileInputStream = new FileInputStream(from);
            while (true) {
                int read = fileInputStream.read(buffer);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(buffer, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
