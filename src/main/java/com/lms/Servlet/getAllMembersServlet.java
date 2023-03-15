package com.lms.Servlet;

import com.lms.Bean.MemberCombine;
import com.lms.Service.MembersService;
import com.lms.Service.MembersServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getAllMembers")
public class getAllMembersServlet extends HttpServlet {
    MembersService getAllMembersServce = new MembersServiceImp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        try {
            List<MemberCombine> members = getAllMembersServce.getAllMembers();
            req.setAttribute("allMembers",members);
            req.getRequestDispatcher("mem_list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }
}
