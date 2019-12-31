package com.programming.cultivation.netty.chapter01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程版服务端
 *
 * @author biyue
 * @since 2019/12/31
 */
public class MultipleThreadServer {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socketClient = serverSocket.accept();
                SocketTask socketTask = new SocketTask(socketClient);
                executorService.submit(socketTask);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
