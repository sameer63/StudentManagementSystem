<%--
  Created by IntelliJ IDEA.
  User: sameer
  Date: 6/19/26
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Student" %>

<html>
<head>
    <title>Students</title>
</head>

<body>

<h2>Student List</h2>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>City</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <%
        List<Student> students =
                (List<Student>) request.getAttribute("students");

        for(Student s : students){
    %>

    <tr>

        <td><%= s.getId() %></td>

        <td><%= s.getName() %></td>

        <td><%= s.getAge() %></td>

        <td><%= s.getCity() %></td>

        <td>
            <a href="editStudent?id=<%= s.getId() %>">
                Edit
            </a>
        </td>

        <td>
            <a href="deleteStudent?id=<%= s.getId() %>"
            onclick="return confirm('Are you sure you want to delete this student?');">
                Delete
            </a>
        </td>

    </tr>

    <%
        }
    %>

</table>
<br>
<a href="addStudent.jsp">Add New Student</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>
