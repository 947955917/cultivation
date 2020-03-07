package com.programming.cultivation.jdk.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 端口测试
 * 端口占用2个字节，0-65536
 * 同一协议下端口不能复用
 *
 *
 */
public class PortDemo {


    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 9999);
        // 打印主机名，端口，主机地址
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
        System.out.println(inetSocketAddress.getHostString());
        System.out.println("------------------------------------------------------------");
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

    }
}
