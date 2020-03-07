package com.programming.cultivation.jdk.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP 就是为了定位节点使用的
 * 计算机、路由器、手机等网络设备
 */
public class IPDemo {

    public static void main(String[] args) {
        try {
            // 打印本地IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getHostName());

            // 根据hostName获取IP地址
            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu.getHostAddress());
            System.out.println(baidu.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
