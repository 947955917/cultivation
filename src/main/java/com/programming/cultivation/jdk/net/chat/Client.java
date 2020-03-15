package com.programming.cultivation.jdk.net.chat;

import com.programming.cultivation.jdk.net.IOUtils;

import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("--------客户端--------");
        Socket client = new Socket("localhost", 9999);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        // 客户端向服务端发送数据
        IOUtils.white(client.getOutputStream(), next);
        // 接收服务端发来的消息
        byte[] read = IOUtils.read(client.getInputStream());
        System.out.println("打印服务端发来的消息:" + new String(read));
    }
}
