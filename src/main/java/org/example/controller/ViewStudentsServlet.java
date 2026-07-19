package org.example.controller;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                         throws IOException, ServletException{
        StudentDAO studentDAO=new StudentDAO();
        List<Student> students=studentDAO.getAllStudents();
        request.setAttribute("students",students);
        request.getRequestDispatcher("students.jsp").forward(request,response);
    }

}
