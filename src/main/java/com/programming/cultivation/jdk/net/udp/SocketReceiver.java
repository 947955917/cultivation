package com.programming.cultivation.jdk.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketReceiver implements Runnable {

    private DatagramSocket socket;
    private String sender;

    public SocketReceiver(String sender, DatagramSocket socket) {
        this.socket = socket;
        this.sender = sender;
    }

    @Override
    public void run() {
        while (true) {
            byte[] buf = new byte[1024 * 80];
            DatagramPacket packet = new DatagramPacket(buf, 1024 * 80);
            try {
                socket.receive(packet);
                System.out.println(sender + "说：" + new String(packet.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}