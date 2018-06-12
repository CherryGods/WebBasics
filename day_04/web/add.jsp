<%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-10
  Time: 下午6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<form action="AddressServlet?method=add" method="post">
    Name:<input type="text" name="name"/><br>
    Street:<input type="text" name="street"/><br>
    City:<input type="text" name="city"/><br>
    State:<input type="text" name="state"/><br>
    Zip:<input type="text" name="zip"/><br>
    <input type="submit" name="add"/><br>
</form>

</body>
</html>
