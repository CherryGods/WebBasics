<%@ page import="org.cherrygods.domain.Address" %><%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-10
  Time: 下午6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<% Address address = (Address) request.getAttribute("address");%>
<form action="AddressServlet?method=edit" method="post">
    <input type="hidden" name="id" value="<%=address.getId()%>"><br>
    Name:<input type="text" name="name"
                value="<%=address.getName()%>"><br>
    Street:<input type="text" name="street" value="<%=address.getStreet()%>"><br>
    City:<input type="text" name="city"
                value="<%=address.getCity()%>"><br>
    State:<input type="text" name="state"
                 value="<%=address.getState()%>"><br>
    Zip:<input type="text" name="zip" value="<%=address.getZip()%>"><br>
    <input type="submit" name="Edit" value="编辑"/><br>
</form>
</body>
</html>
