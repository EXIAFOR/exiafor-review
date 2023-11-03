package cn.exiafor.skzy.userlog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Disposition", "attachment;fileName=1.jpg");
        resp.getOutputStream().write("sduisbfsbfouisdf".getBytes());
    }
}
