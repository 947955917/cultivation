package com.programming.cultivation;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class HttpDemo {

    public static void main(String[] args) {
        List<String> url = new ArrayList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        int i = 1;
        while (i < 1000) {
            try {
                String uri = "https://www.stt" + i + ".com";
//                String uri = "https://www.baidu.com";
                System.out.println("uri:" + uri);
                HttpGet httpGet = new HttpGet(uri);
                CloseableHttpResponse response = httpClient.execute(httpGet);
                System.out.println(response.toString());
                url.add(uri);
                System.out.println("************************************************************");
                for (String s : url) {
                    System.out.println(s);
                }
            } catch (IOException e) {
            }
            i++;
        }


    }
}
