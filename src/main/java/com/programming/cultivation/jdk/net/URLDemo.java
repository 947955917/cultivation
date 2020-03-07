package com.programming.cultivation.jdk.net;

import java.net.InetAddress;
import java.net.URL;

public class URLDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com/s?wd=22&rsv_spt=1&rsv_iqid=0xb2a4aaae00228312&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_dl=tb&rsv_enter=0&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&inputT=988&rsv_sug4=1434#fuck");

        System.out.println("协议:" + url.getProtocol());
        System.out.println("域名:" + url.getHost());
        System.out.println("端口:" + url.getPort());
        System.out.println("请求资源:" + url.getFile());
        System.out.println("请求资源:" + url.getPath());

        System.out.println("参数" + url.getQuery());
        System.out.println("锚点" + url.getRef());

        InetAddress inetAddress = InetAddress.getByName(url.getHost());
        System.out.println("bilibili的IP地址" + inetAddress.getHostAddress());


    }
}
