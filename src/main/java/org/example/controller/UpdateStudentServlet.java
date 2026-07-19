package org.example.controller;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String city=request.getParameter("city");

        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setCity(city);

        StudentDAO dao=new StudentDAO();
        boolean updated=dao.updateStudent(student);

        if(updated){
            response.sendRedirect("viewStudents");
        }else{
            response.getWriter().println("Update Failed!");
        }
    }
}
