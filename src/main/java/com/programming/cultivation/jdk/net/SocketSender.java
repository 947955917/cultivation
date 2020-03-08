package com.programming.cultivation.jdk.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class SocketSender implements Runnable {

    private DatagramSocket sender;
    private InetSocketAddress target;

    public SocketSender(DatagramSocket sender, InetSocketAddress target) {
        this.sender = sender;
        this.target = target;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String content = scanner.next();
            byte[] bytes = content.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, target);
            try {
                sender.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
