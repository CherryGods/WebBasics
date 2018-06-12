package org.chezygods.servlet;

import org.chezygods.utils.DBHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DemoServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("user:"+user+"password:"+password);
        String[] list = request.getParameterValues("interesting");
        for (String s : list) {
            System.out.println(s);
        }
        Enumeration<String> eList = request.getParameterNames();
        while (eList.hasMoreElements()){
            System.out.println("name:"+eList.nextElement());
        }

        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey());
            System.out.println(Arrays.asList(stringEntry.getValue()));
        }


        //获取请求的地址URI
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        System.out.println(uri);
        //获取请求方式
        String method = httpRequest.getMethod();
        System.out.println(method);
        //获取请求的地址URL
        StringBuffer URL = httpRequest.getRequestURL();
        System.out.println(URL.toString());
        //打印数据到浏览器页面上
        PrintWriter print = response.getWriter();
        print.write("HelloWorld");

        response.setContentType("application/msword" );


        HttpServletResponse httpResponse = (HttpServletResponse) response;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
