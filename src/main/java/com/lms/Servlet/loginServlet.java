package com.lms.Servlet;

import com.lms.Service.loginService;
import com.lms.Service.loginServiceimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    loginService ls = new loginServiceimp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String username=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        try {
            boolean  isLogin = ls.login(username,pwd);
            if (isLogin){

                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else{
                req.setAttribute("error","The username and password doesn't match");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }
}
