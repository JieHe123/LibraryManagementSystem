package com.lms.Servlet;

import com.lms.Bean.Member;
import com.lms.Service.MembersService;
import com.lms.Service.MembersServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addMember")
public class addMemberServlet extends HttpServlet {
    MembersService memberModifyService =new MembersServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        Member member =new Member();
        String name =  req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String memberType = req.getParameter("memberType");
        String balance = req.getParameter("balance");
        String tel = req.getParameter("tel");
        String idNumber= req.getParameter("idNumber");

        member.setName(name);
        member.setPwd(pwd);
        member.setTypeId(Long.parseLong(memberType));
        member.setBalance(Double.parseDouble(balance));
        member.setTel(tel);
        member.setIdNumber(idNumber);
        String isAdded="";

        try {
            isAdded = memberModifyService.addMember(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("state",isAdded);
        req.getRequestDispatcher("mem_add.jsp").forward(req,resp);

    }
}
