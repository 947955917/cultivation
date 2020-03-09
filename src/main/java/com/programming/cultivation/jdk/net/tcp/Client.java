package com.programming.cultivation.jdk.net.tcp;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * TCP 客户端
 * 1、发起连接
 * 2、获取字节输出流
 * 3、输出字节数据
 * 4、关闭流
 * 5、关闭连接
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        System.out.println(socket.getPort());
        System.out.println(socket.getLocalPort());

//        socket.connect(new InetSocketAddress("localhost",9999));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是客户端".getBytes());
//        socket.close();
//        Thread.sleep(3000);
    }
}
