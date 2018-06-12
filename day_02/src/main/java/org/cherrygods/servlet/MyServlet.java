package org.cherrygods.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@SuppressWarnings("all")
public class MyServlet extends MyHttpServlet{
    @Override
    public void service(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        String user = res.getParameter("user");
        String password = res.getParameter("password");
        System.out.printf("user:" + user + "\npassword:" + password);
        String initUser = getServletContext().getInitParameter("initUser");
        String initPassword = getServletContext().getInitParameter("initPassword");
        System.out.println("\ninitUser:" + initUser + "\ninitPassword" + initPassword);
        PrintWriter out = resp.getWriter();
        if (user.equals(initUser) && password.equals(initPassword)) {
            out.write("Hello," + user);
        } else {
            out.write("Sorry," + user);
        }
        String method = res.getMethod();
        System.out.println(method);
    }

    @Override
    public void doPost(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
    }
}
