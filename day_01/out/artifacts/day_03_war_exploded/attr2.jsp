<%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-12
  Time: 下午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
    pageContext:<%=pageContext.getAttribute("pageContextAttr")%>
    <br><br>
    request:<%=request.getAttribute("requestAttr")%>
    <br><br>
    session:<%=session.getAttribute("sessionAttr")%>
    <br><br>
    application:<%=application.getAttribute("applicationAttr")%>
</body>
</html>
