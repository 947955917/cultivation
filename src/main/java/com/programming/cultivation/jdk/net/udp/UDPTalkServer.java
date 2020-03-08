package com.programming.cultivation.jdk.net.udp;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、创建Socket
 * 2、创建数据报包
 * 3、用阻塞式receive方法获取数据
 * 4、处理数据
 */
public class UDPTalkServer {


    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 创建服务端Socket
        DatagramSocket customer = new DatagramSocket(10001);
        // 创建接收客户端数据报包的任务
        SocketReceiver receiver = new SocketReceiver("顾客", customer);
        // 提交任务
        executorService.submit(receiver);
        // 目标地址
        InetSocketAddress target = new InetSocketAddress("localhost", 20000);
        SocketSender socketSender = new SocketSender(new DatagramSocket(10000), target);
        //executorService.submit(socketSender);
        socketSender.run();
    }


}
