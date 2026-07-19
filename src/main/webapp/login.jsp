<%--
  Created by IntelliJ IDEA.
  User: sameer
  Date: 6/19/26
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Login</title>
</head>

<body>
<%
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>

<p style="color:red;">
    <%= error %>
</p>

<%
    }
%>

<h2>Admin Login</h2>

<form action="login" method="post">

    Username

    <input type="text" name="username">

    <br><br>

    Password

    <input type="password" name="password">

    <br><br>

    <input type="submit" value="Login">

</form>

</body>

</html>
