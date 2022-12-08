<%--
  Created by IntelliJ IDEA.
  User: Sall
  Date: 06/12/2022
  Time: 08:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="InsertData" method="POST">
    <p>ID:</p>
    <!-- Create an element with mandatory name attribute,
    so that data can be transfer to the servlet using getParameter() -->
    <input type="text" name="id"/>
    <br/>
    <p>String:</p>
    <input type="text" name="string"/>
    <br/><br/><br/>
    <input type="submit"/>
</form>
</body>
</html>
