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

@WebServlet("/topUp")
public class topUpServlet extends HttpServlet {
    MembersService memberModifyService =new MembersServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        String idNumber=req.getParameter("idNumber");
//        Member member=memberModifyService.getMemberById(idNumber);
//        req.setAttribute("idNumber",member.getIdNumber());
//        req.getRequestDispatcher("mem_recharge.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Member member = new Member();
        String idNumber= req.getParameter("idNumber");
        String balance = req.getParameter("amount");

        member.setIdNumber(idNumber);
        member.setBalance(Double.parseDouble(balance));
        boolean isModified = false;
        try {
            isModified = memberModifyService.topup(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isModified){
            req.setAttribute("success","Successfully updated");
            req.getRequestDispatcher("mem_recharge.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","TopUp failed, please try it again");
            req.getRequestDispatcher("mem_recharge.jsp").forward(req,resp);
        }
    }
}
