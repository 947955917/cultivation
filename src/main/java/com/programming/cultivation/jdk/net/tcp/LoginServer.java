package com.programming.cultivation.jdk.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 登录服务端
 */
public class LoginServer {


    public static void main(String[] args) throws Exception {
        // 创建一个ServerSocket,监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 获取Socket套接字
        Socket socket = serverSocket.accept();

        // 使用IO流读取输入数据
        InputStream inputStream = socket.getInputStream();
        byte[] dataByte = new byte[60 * 1024];
        int read = inputStream.read(dataByte);
        // 验证用户名密码
        String data = new String(dataByte, 0, read);
        System.out.println("客户端发送的数据：" + data);
        String[] split = data.split("&");
        String username = split[0];
        String password = split[1];
        System.out.println(username + "&" + password);
        String result = "账号或者密码错误，登录失败";
        if ("张三".equals(username) && "zhangsan1234..".equals(password)) {
            // 登录成功
            result = "登录成功";
        }
        // 返回登录结果
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(result.getBytes());
        outputStream.close();
        // 关闭客户端Socket
        socket.close();
        // 关闭服务端Socket
        serverSocket.close();


    }

}
