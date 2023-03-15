package com.lms.Servlet;

import com.lms.Bean.Member;
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

@WebServlet("/delMember")
public class delMemberServlet extends HttpServlet {
    MembersService memberModifyService =new MembersServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id = req.getParameter("id");
        Member member = new Member();
        member.setId(Long.parseLong(id));
        try {
            memberModifyService.delMember(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<MemberCombine> members = null;
        try {
            members = memberModifyService.getAllMembers();

        req.setAttribute("allMembers",members);
        req.getRequestDispatcher("mem_list.jsp").forward(req,resp);
        }catch (SQLException e) {
            e.printStackTrace();
        }



        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);



    }
}
