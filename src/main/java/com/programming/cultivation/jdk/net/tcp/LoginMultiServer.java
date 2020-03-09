package com.programming.cultivation.jdk.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录服务端
 */
public class LoginMultiServer {

    public static Map<String, String> userInfo = new HashMap<>();

    static {
        userInfo.put("张三", "1234");
        userInfo.put("李四", "1234");
        userInfo.put("王五", "1234");
    }


    public static void main(String[] args) throws Exception {
        // 创建一个ServerSocket,监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        // 获取Socket套接字
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("监听到连接");
            new Thread(new Channel(socket)).start();

        }
    }

    static class Channel implements Runnable {

        private Socket socket;

        public Channel(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 使用IO流读取输入数据
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] dataByte = new byte[60 * 1024];
                int read = inputStream.read(dataByte);
                String data = new String(dataByte, 0, read);
                // 验证用户名密码
                System.out.println("客户端发送的数据：" + data);
                String[] split = data.split("&");
                String username = split[0];
                String password = split[1];
                String result = "账号或者密码错误，登录失败";
                String pwd = userInfo.get(username);
                if (pwd != null && pwd.equals(password)) {
                    // 登录成功
                    result = "登录成功";
                }
                // 返回登录结果
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(result.getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
