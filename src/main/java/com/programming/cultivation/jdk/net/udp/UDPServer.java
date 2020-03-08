package com.programming.cultivation.jdk.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.Charset;

/**
 * 1、创建Socket
 * 2、创建数据报包
 * 3、用阻塞式receive方法获取数据
 * 4、处理数据
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {
        // 创建数据报包服务端
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] buf = new byte[102400];
        DatagramPacket datagramPacket = new DatagramPacket(buf, 102400);
        while (true) {
            // 阻塞式接受数据报包
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            System.out.println("data:" + new String(data, Charset.forName("UTF-8")));
        }
    }
}
