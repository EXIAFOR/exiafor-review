package cn.exiafor.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req.getCharacterEncoding() : " + req.getCharacterEncoding());
        System.out.println("resp.getCharacterEncoding() : " + resp.getCharacterEncoding());

        resp.getWriter().write("成功访问到服务器");
        System.out.println("连接到服务器");
    }
}
