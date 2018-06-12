package org.cherrygods.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends MyGenericServlet{
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletResponse httpServletResponse;
        HttpServletRequest httpServletRequest;
        try {
            httpServletRequest = (HttpServletRequest) servletRequest;
            httpServletResponse = (HttpServletResponse) servletResponse;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
            service(httpServletRequest,httpServletResponse);
    }
    public void service(HttpServletRequest res,HttpServletResponse resp)throws ServletException, IOException{
        String method = res.getMethod();
        if("GET".equalsIgnoreCase(method)){
            doGet(res,resp);
        }else if("POST".equalsIgnoreCase(method)){
            doPost(res,resp);
        }
    }
    public void doPost(HttpServletRequest res,HttpServletResponse resp)throws ServletException, IOException{
    }
    public void doGet(HttpServletRequest res,HttpServletResponse resp)throws ServletException, IOException{
    }
}

