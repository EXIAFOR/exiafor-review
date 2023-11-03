package cn.exiafor;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpURLConnection connection = new HttpURLConnection(new URL("https://www.qq.com"), null);

        connection.setInstanceFollowRedirects(false);
        InputStream is = connection.getInputStream();

        byte[] buffer = new byte[32 * 1024];

        StringBuilder sb = new StringBuilder();

        int len;
        while ((len = is.read(buffer)) != -1) {
            System.out.println("len : " + len);
            sb.append(new String(buffer, 0, len));
        }

        System.out.println(sb);

        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.println("debug -- 1");

        System.out.println("free : all --> " + freeMemory / 1024 + "/" + totalMemory / 1024);
    }
}
