package org.example.controller;


import org.example.dao.StudentDAO;
import org.example.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                 throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));

        StudentDAO dao=new StudentDAO();
        Student student=dao.getStudentById(id);

        request.setAttribute("student",student);
        RequestDispatcher rd=request.getRequestDispatcher("editStudent.jsp");
        rd.forward(request,response);
    }

}