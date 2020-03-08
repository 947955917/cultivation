package com.programming.cultivation.jdk.net.udp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络爬虫的原理
 */
public class SpiderTest01 {

    public static void main(String[] args) throws Exception {

        // 获取URL
        URL url = new URL("https://www.dianping.com/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");
        // 下载资源
        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
        String msg = null;
        while (null != (msg = br.readLine())) {
            System.out.println(msg);
        }


    }

}
