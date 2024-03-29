package cn.exiafor.skzy;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init 初始化方法");
        System.out.println("servletConfig.getServletName() : " + servletConfig.getServletName());
        System.out.println("servletConfig.getInitParameter(\"username\") : " + servletConfig.getInitParameter("username"));
        System.out.println("servletConfig.getInitParameter(\"url\")" + servletConfig.getInitParameter("url"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");// 类型转换（因为它有 getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;// 获取请求的方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * 做 get 请求的操作
     */
    public void doGet() {
        System.out.println("get 请求");
        System.out.println("get 请求");
    }

    /**
     * 做 post 请求的操作
     */
    public void doPost() {
        System.out.println("post 请求");
        System.out.println("post 请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
