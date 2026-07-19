package org.example.controller;

import org.example.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

        throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("id"));

        StudentDAO dao=new StudentDAO();
        boolean deleted=dao.deleteStudent(id);

        if(deleted){
            response.sendRedirect("viewStudents");
        }else {
            response.getWriter().println("Deletion Failed!");
        }
    }
}