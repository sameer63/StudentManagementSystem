package org.example.controller;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setCity(city);

        StudentDAO studentDAO = new StudentDAO();
        boolean success =studentDAO.addStudent(student);

       if(success){
           response.sendRedirect("viewStudents?success=true");
       }else {
           response.getWriter().println("Failed to add student");
       }
    }
}