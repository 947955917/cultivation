package com.programming.cultivation.jdk.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClient {


    public static void main(String[] args) throws Exception {
        // 使用Socket 指定服务端IP+端口，连接到服务端
        Socket clinet = new Socket("localhost", 9999);
        // 使用输出流，将账号密码发到服务端
        OutputStream outputStream = clinet.getOutputStream();
        outputStream.write("张三&zhangsan1234..".getBytes());
        // 读取输入流，读取登录结果
        Thread.sleep(2000);
        InputStream inputStream = clinet.getInputStream();
        byte[] dataBytes = new byte[60 * 1024];
        int read = inputStream.read(dataBytes);
        System.out.println("登录结果：" + new String(dataBytes, 0, read));
    }
}
