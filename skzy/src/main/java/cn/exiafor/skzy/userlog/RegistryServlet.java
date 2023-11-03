package cn.exiafor.skzy.userlog;

import cn.exiafor.skzy.userlog.bean.User;
import cn.exiafor.skzy.userlog.bean.UserTable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        UserTable.addUser(new
                User(username, password, email, code));
    }
}
