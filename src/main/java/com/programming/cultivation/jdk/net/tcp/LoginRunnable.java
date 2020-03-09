package com.programming.cultivation.jdk.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginRunnable implements Runnable {

    private Socket clinet;

    private String username;
    private String password;

    public LoginRunnable(Socket socket, String username, String password) {
        this.clinet = socket;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        try {
            // 使用Socket 指定服务端IP+端口，连接到服务端
            // 使用输出流，将账号密码发到服务端
            OutputStream outputStream = clinet.getOutputStream();
            StringBuffer buffer = new StringBuffer(username).append("&").append(password);
            outputStream.write(buffer.toString().getBytes());
            // 读取输入流，读取登录结果
            InputStream inputStream = clinet.getInputStream();
            byte[] dataBytes = new byte[60 * 1024];
            int read = inputStream.read(dataBytes);
            System.out.println("登录结果：" + username + new String(dataBytes, 0, read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
