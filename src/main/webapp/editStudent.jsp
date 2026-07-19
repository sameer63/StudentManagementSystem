<%@ page import="org.example.model.Student"%>

<%
    Student student =
            (Student) request.getAttribute("student");
%>

<html>

<body>

<h2>Edit Student</h2>

<form action="updateStudent" method="post">

    <input type="hidden"
           name="id"
           value="<%=student.getId()%>">

    Name

    <input type="text"
           name="name"
           value="<%=student.getName()%>">

    <br><br>

    Age

    <input type="number"
           name="age"
           value="<%=student.getAge()%>">

    <br><br>

    City

    <input type="text"
           name="city"
           value="<%=student.getCity()%>">

    <br><br>

    <input type="submit"
           value="Update Student">

</form>

</body>

</html>