package com.programming.cultivation.jdk.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1、创建Socket
 * 2、创建数据报包
 * 3、写入数据，写入服务端IP+端口
 * 4、发送数据报包
 */
public class UPDClient {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 9999);
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        int i = 0;
        while (i++ < 600) {
            String now = "客户端当前时间：" + sdf.format(new Date());
            System.out.println("客户端，第" + i + "次发送数据，数据内容：" + now);
            byte[] bytes = now.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, serverAddress);
            // 服务端地址
            datagramSocket.send(datagramPacket);
            // 隔1秒发一次
            Thread.sleep(1000);
        }

    }
}
