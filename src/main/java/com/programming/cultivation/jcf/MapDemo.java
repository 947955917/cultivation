package com.programming.cultivation.jcf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {
        List<PlaceHolder> list = new LinkedList<>();
        int i = 0;
        // 1秒增加5MB
        while (true) {
            list.add(new PlaceHolder());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += 1;
            System.out.println("占用内存：" + i + "MB!");
        }
    }

    static class PlaceHolder {
        // 1mb
        byte[] data = new byte[1024 * 1024];
    }
}
