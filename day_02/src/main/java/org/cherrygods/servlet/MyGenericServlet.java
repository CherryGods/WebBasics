package org.cherrygods.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 用于简化Servlet编写
 *
 * @author cherrygods
 * @since 2018-06-07 14:40:12
 */
public abstract class MyGenericServlet implements Servlet, ServletConfig {
    /*以下方法为Servlet接口的方法*/
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        this.init();
    }

    public void init() throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }/**/

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    /*以下方法为ServletConfig接口的方法*/
    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String s) {
        return servletConfig.getInitParameter(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}
