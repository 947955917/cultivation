package com.programming.cultivation.jdk.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOUtils {


    public static void white(OutputStream os, String content) {
        try {
            os.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] read(InputStream is) {
        byte[] data = new byte[1024 * 100];
        try {
            int read = is.read(data);
            return Arrays.copyOf(data, read);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
