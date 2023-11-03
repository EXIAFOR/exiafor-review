package cn.exiafor.skzy.userlog;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream is = req.getInputStream();

        System.out.println("req.getContentType() : " + req.getContentType());

        byte[] buffer = new byte[16 * 1024];

        int len;
        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer,0,len));
        }
    }
}
