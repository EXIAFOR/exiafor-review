package net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDownload {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://uploadstatic.mihoyo.com/contentweb/20210922/2021092217442572336.png");

        String fileName = url.getPath().substring(url.getPath().lastIndexOf('/') + 1);

        URLConnection connection = url.openConnection();

        connection.connect();

        InputStream is = connection.getInputStream();

        FileOutputStream fos = new FileOutputStream(fileName);

        byte[] buffer = new byte[10240];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();

        System.out.println("下载完成");
    }
}
