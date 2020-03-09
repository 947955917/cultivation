package com.programming.cultivation.jdk.net.chat;

import com.programming.cultivation.jdk.net.IOUtils;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务端
 * 目标：实现一个客户端可以收发消息
 */
public class Chat {

    public static void main(String[] args) throws Exception {
        System.out.println("------Server--------");
        // 创建服务端
        ServerSocket server = new ServerSocket(9999);
        // 接收连接
        Socket client = server.accept();
        System.out.println("客户端建立了连接");
        byte[] read = IOUtils.read(client.getInputStream());
        // 打印客户端发来消息
        System.out.println("打印客户端发来消息:" + new String(read));
        // 将消息发回客户端
        System.out.println("将消息发回客户端");
        IOUtils.white(client.getOutputStream(), new String(read));


    }
}
