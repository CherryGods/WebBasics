<%@ page import="org.cherrygods.domain.Address" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cherrygods
  Date: 18-6-10
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <td>Name</td>
      <td>Street</td>
      <td>City</td>
      <td>State</td>
      <td>Zip</td>
      <td><center>Options</center></td>
    <tr>
        <%
List<Address> list = (List<Address>)request.getAttribute("list");
for(Address a :list){

%>
    <tr>
      <td><%=a.getName()%></td>
      <td><%=a.getStreet() %></td>
      <td> <%=a.getCity()%></td>
      <td><%=a.getState()%></td>
      <td><%=a.getZip() %></td>
      <td>
        <a href="AddressServlet?method=delete&id=<%=a.getId() %>">Delete</a>&nbsp;
        <a href="AddressServlet?method=toedit&id=<%=a.getId() %>">Edit</a>
      </td>

    </tr>
    <%}%>
  </table>
  <a href="add.jsp">Add</a>
  </body>
</html>
