package com.programming.cultivation.netty.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author biyue
 * @since 2019/12/31
 */
public class SocketTask implements Runnable{

    private Socket clientSocket;

    public SocketTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String text = null;
            while ((text = bufferedReader.readLine()) != null) {
                System.out.println(text);
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
