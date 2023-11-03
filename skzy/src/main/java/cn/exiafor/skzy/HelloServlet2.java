package cn.exiafor.skzy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写初始化方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet2 的 doGet 方法");
        ServletContext context = getServletContext();
        System.out.println("context.getContextPath() : " + context.getContextPath());
        System.out.println("context.getRealPath(\"/\") : " + context.getRealPath("/"));
        System.out.println("context.getRealPath(\"/imgs/1.jpg\") : " + context.getRealPath("/imgs/1.jpg"));
        System.out.println("context.getInitParameter(\"username\") : " + context.getInitParameter("username"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet2 的 doPost 方法");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet2 的 doPut 方法");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet2 的 doDelete 方法");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet2 的 doOptions 方法");
    }
}
