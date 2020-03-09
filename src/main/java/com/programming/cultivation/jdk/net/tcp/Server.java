package com.programming.cultivation.jdk.net.tcp;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务端
 * 1、建立服务端Socket
 * 2、监听端口
 * 3、获取Socket连接
 * 4、获取IO流
 * 6、处理数据
 * 7、关闭连接
 */
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 9999));
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("远程端口：" + socket.getPort());
            System.out.println("本地端口：" + socket.getLocalPort());
            InputStream inputStream = socket.getInputStream();
            byte[] data = new byte[1024 * 60];
            inputStream.read(data);
            System.out.println(new String(data));
            socket.close();
        }
    }
}
