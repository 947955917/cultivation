package com.programming.cultivation.netty.chapter01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author biyue
 * @since 2019/12/31
 */
public class Client {

    private static final String host = "";

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Socket socket = new Socket(host, 8080);
                OutputStream outputStream = socket.getOutputStream();
                String message = "第" + i + "个socket client message send to server";
                outputStream.write(message.getBytes());
                outputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
