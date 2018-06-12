<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-11
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       String age = request.getParameter("age");
       if(Integer.valueOf(age)>=18){
   %>
        成年
   <%
       }else{
    %>
        未成年
   <%
       }
   %>
</body>
</html>
