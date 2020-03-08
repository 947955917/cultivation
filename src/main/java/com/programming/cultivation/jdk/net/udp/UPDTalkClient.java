package com.programming.cultivation.jdk.net.udp;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、创建Socket
 * 2、创建数据报包
 * 3、写入数据，写入服务端IP+端口
 * 4、发送数据报包
 */
public class UPDTalkClient {

    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 创建服务端Socket
        DatagramSocket customer = new DatagramSocket(20000);
        // 创建接收客户端数据报包的任务
        SocketReceiver receiver = new SocketReceiver("老板", customer);
        // 提交任务
        executorService.submit(receiver);
        // 目标地址
        InetSocketAddress target = new InetSocketAddress("localhost", 10001);
        SocketSender socketSender = new SocketSender(new DatagramSocket(20001), target);
//        executorService.submit(socketSender);
        socketSender.run();
    }
}
