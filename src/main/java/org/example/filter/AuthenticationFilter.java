package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse) response;

        HttpSession session=req.getSession(false);

        boolean loggedIn =
                session != null &&
                        session.getAttribute("admin") != null;

        String uri = req.getRequestURI();

        if (loggedIn ||
                uri.endsWith("login.jsp") ||
                uri.endsWith("login")) {

            chain.doFilter(request, response);

        } else {

            res.sendRedirect("login.jsp");
        }

    }

}
