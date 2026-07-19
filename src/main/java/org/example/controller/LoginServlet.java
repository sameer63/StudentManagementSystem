package org.example.controller;

import org.example.dao.AdminDAO;
import org.example.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
       String username=request.getParameter("username");
       String password=request.getParameter("password");

       AdminDAO dao=new AdminDAO();
        Admin admin=dao.login(username,password);
        if(admin!=null){
            HttpSession session=request.getSession();
            session.setAttribute("admin",admin);
            response.sendRedirect("viewStudents");
        }else {
            request.setAttribute("error", "Invalid Username or Password");

            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
}