package org.cherrygods.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestAttr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.在Servlet中无法得到pageContext的属性
        //2.request
        PrintWriter out = resp.getWriter();
        Object requestAttr = req.getAttribute("requestAttr");
        out.println("requestAttr:"+requestAttr);
        out.println("<br><br");
        //.session
        Object sessionAttr = req.getAttribute("sessionAttr");
        out.println("sessionAttr:"+sessionAttr);
        out.println("<br><br");
        //4.application
        Object applicationAttr = req.getAttribute("applicationAttr");
        out.println("applicationAttr:"+applicationAttr);
        out.println("<br><br");
    }
}
