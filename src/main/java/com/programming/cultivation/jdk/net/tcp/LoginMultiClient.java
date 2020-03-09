package com.programming.cultivation.jdk.net.tcp;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginMultiClient {


    public static void main(String[] args) throws Exception {
        // 共用同一个连接
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        LoginRunnable loginRunnable = new LoginRunnable(new Socket("localhost", 9999), "张三", "1234");
        LoginRunnable loginRunnable2 = new LoginRunnable(new Socket("localhost", 9999), "李四", "1234");
        LoginRunnable loginRunnable3 = new LoginRunnable(new Socket("localhost", 9999), "王五", "1234");
        executorService.submit(loginRunnable);
        executorService.submit(loginRunnable2);
        executorService.submit(loginRunnable3);
    }
}
