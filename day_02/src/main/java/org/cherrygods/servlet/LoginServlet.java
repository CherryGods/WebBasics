package org.cherrygods.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends MyGenericServlet {
    @Override
    public void init()throws ServletException {
        System.out.println("初始化");
    }
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.printf("user:" + user + "\npassword:" + password);
        String initUser = getServletContext().getInitParameter("initUser");
        String initPassword = getServletContext().getInitParameter("initPassword");
        System.out.println("\ninitUser:" + initUser + "\ninitPassword" + initPassword);
        PrintWriter out = response.getWriter();
        if (user.equals(initUser) && password.equals(initPassword)) {
            out.write("Hello," + user);
        } else {
            out.write("Sorry," + user);
        }
    }
}
