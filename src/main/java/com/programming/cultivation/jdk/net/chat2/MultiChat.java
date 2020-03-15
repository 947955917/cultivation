package com.programming.cultivation.jdk.net.chat2;

import com.programming.cultivation.jdk.net.IOUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在线聊天室：服务端
 * 目标：实现多个客户可以收多发消息
 */
public class MultiChat {

    private volatile static List<Socket> clientContainer = new ArrayList<>();
    private volatile static ArrayBlockingQueue<Socket> clientQuene = new ArrayBlockingQueue<>(20);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        // 创建服务端
        ServerSocket server = new ServerSocket(9999);
        PortMonitor portMonitor = new PortMonitor(server, clientContainer, clientQuene);
        executorService.submit(portMonitor);
        while (true) {
            Socket poll = clientQuene.take();
            executorService.submit(new Transponder(poll, clientContainer));
        }
    }

    private static class Transponder implements Runnable {

        private Socket client;

        private String name;

        private List<Socket> clientContainer;

        public Transponder(Socket client, List<Socket> clientContainer) {
            this.client = client;
            this.clientContainer = clientContainer;
            try {
                byte[] read = IOUtils.read(client.getInputStream());
                name = new String(read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    byte[] read = IOUtils.read(client.getInputStream());
                    // 将消息发回容器中的客户端
                    for (Socket socket : clientContainer) {
                        if (socket == client) {
                            continue;
                        }
                        IOUtils.white(socket.getOutputStream(), name + "说：" + new String(read));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 端口监视器，用于监听连接
     */
    private static class PortMonitor implements Runnable {
        private ServerSocket serverSocket;
        private List<Socket> clientContainer;
        private ArrayBlockingQueue<Socket> clientPool;

        public PortMonitor(ServerSocket serverSocket, List<Socket> sockets, ArrayBlockingQueue<Socket> queue) {
            this.serverSocket = serverSocket;
            this.clientContainer = sockets;
            this.clientPool = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    System.out.println("新增一个客户端");
                    clientContainer.add(client);
                    clientPool.put(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
