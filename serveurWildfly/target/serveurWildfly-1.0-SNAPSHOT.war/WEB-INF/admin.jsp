<%--
  Created by IntelliJ IDEA.
  User: Sall
  Date: 05/12/2022
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>La page admin</h1>
<h1>
    <%
    String nom  = request.getParameter("nom");
    %>
    <p>Le nom par jsp: <% System.out.println(nom);
    %></p>
</h1>
</body>
</html>
