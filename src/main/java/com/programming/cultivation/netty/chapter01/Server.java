package com.programming.cultivation.netty.chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程服务端
 *
 * @author biyue
 * @since 2019/12/31
 */
public class Server {


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                // accept() 阻塞方法，底层估计是从一个队列里获取所有socket请求
                Socket clientSocket = serverSocket.accept();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String text = null;
                // readLine()方法会阻塞，严重影响其他socket的处理
                while ((text = bufferedReader.readLine()) != null) {
                    System.out.println(text);
                }
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
