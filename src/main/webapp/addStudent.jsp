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
    <title>Add Student</title>
</head>
<body>
<form action="addStudent" method="post">
    Name : <input type="text" name="name"><br><br>
    Age : <input type="text" name="age"><br><br>
    City : <input type="text" name="city"><br><br>
    <input type="submit" value="Add Student">
</form>
<%
    if ("true".equals(request.getParameter("success"))) {
%>

<p style="color:green;">Student added successfully!</p>

<%
    }
%>

</body>
</html>
