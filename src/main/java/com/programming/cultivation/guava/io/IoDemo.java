package com.programming.cultivation.guava.io;


import com.google.common.io.CharStreams;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author biyue
 * @since 2019/12/18
 */
public class IoDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws Exception {
        singleThread_001();
//        singleThread_002();
//        threadPool();
    }

    /**
     * 单线程第一版
     * time:22534
     * time:22002
     * time:22231
     *
     * @throws Exception
     */
    public static void singleThread_001() throws Exception {
        long start = System.currentTimeMillis();
        File file = new File("E:\\night\\three");
        File[] files = file.listFiles();
        for (File from : files) {
            File to = new File("E:\\night\\four" + File.separator + from.getName());
            Files.copy(from, to);
        }
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }

    /**
     * 单线程第二版
     * time:85072
     *
     * @throws Exception
     */
    public static void singleThread_002() throws Exception {
        long start = System.currentTimeMillis();
        File file = new File("E:\\night\\one");
        File[] files = file.listFiles();
        for (File from : files) {
            File to = new File("E:\\night\\two" + File.separator + from.getName());
            BufferedReader bufferedReader = Files.newReader(from, Charset.defaultCharset());
            BufferedWriter bufferedWriter = Files.newWriter(to, Charset.defaultCharset());
            CharStreams.copy(bufferedReader, bufferedWriter);
        }
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }

    /**
     * 线程池第一版 22000
     *
     * @throws Exception
     */
    public static void threadPool_001() throws Exception {
        long start = System.currentTimeMillis();
        File file = new File("E:\\night\\one");
        File[] files = file.listFiles();
        CountDownLatch countDownLatch = new CountDownLatch(files.length);
        for (File from : files) {
            File to = new File("E:\\night\\two" + File.separator + from.getName());
            executorService.submit(new FileCopyTask(from, to, countDownLatch));
        }
        System.out.println("任务提交完毕");
        countDownLatch.await();
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }
}
