package com.programming.cultivation.guava.io;

import com.google.common.io.Files;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author biyue
 * @since 2019/12/19
 */
public class FileCopyTask implements Callable<String> {

    private File from;
    private File to;
    private CountDownLatch countDownLatch;

    public FileCopyTask(File from, File to,CountDownLatch countDownLatch) {
        this.from = from;
        this.to = to;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("开始拷贝文件" + from.getName());
        long start = System.currentTimeMillis();
        Files.copy(from, to);
        System.out.println(from.getName() + "拷贝成功，耗时" + (System.currentTimeMillis() - start) + "毫秒");
        countDownLatch.countDown();
        return "";
    }
}
