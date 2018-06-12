<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    System.out.println(name);

    Class clazz = response.getClass();
    System.out.println(response instanceof HttpServletResponse);
    System.out.println(session.getId());
    System.out.println(application.getInitParameter("user"));
    System.out.println(config.getInitParameter("test"));
    System.out.println(this);
    System.out.println(page);
    request.getAttribute("");
    request.getAttributeNames();
%>
</body>
</html>
