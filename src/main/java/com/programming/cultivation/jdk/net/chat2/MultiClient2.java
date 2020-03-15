package com.programming.cultivation.jdk.net.chat2;

import com.programming.cultivation.jdk.net.IOUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiClient2 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("--------客户端--------");
        Socket client = new Socket("localhost", 9999);
        IOUtils.white(client.getOutputStream(), "李四");
        Lister lister = new Lister(client);
        executorService.submit(lister);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            // 客户端向服务端发送数据
            IOUtils.white(client.getOutputStream(), next);
        }
    }

    private static class Lister implements Runnable {

        private Socket client;

        public Lister(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    byte[] read = IOUtils.read(client.getInputStream());
                    System.out.println(new String(read));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
