<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-11
  Time: 下午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    <h1>Attr1.jsp<%=new Date()%></h1>
    <%
        pageContext.setAttribute("pageContextAttr","pageContextValue");
        request.setAttribute("requestAttr","requestValue");
        session.setAttribute("sessionAttr","sessionValue");
        application.setAttribute("applicationAttr","applicationValue");
    %>
    <br><br>
    pageContext:<%=pageContext.getAttribute("pageContextAttr")%>
    <br><br>
    request:<%=request.getAttribute("requestAttr")%>
    <br><br>
    session:<%=session.getAttribute("sessionAttr")%>
    <br><br>
    application:<%=application.getAttribute("applicationAttr")%>
    <br><br>
    <a href="attr2.jsp">To Attr2Jsp</a>
    <a href="testattr">To Servlet</a>
</body>
</html>
