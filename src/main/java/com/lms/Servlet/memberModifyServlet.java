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

@WebServlet("/memberModify")
public class memberModifyServlet extends HttpServlet {
    MembersService memberModifyService =new MembersServiceImp();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        String id=req.getParameter("id");
        Member member=memberModifyService.getMemberById(id);
        req.setAttribute("member",member);
        req.getRequestDispatcher("mem_modify.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String typeId = req.getParameter("memberType");
        String balance = req.getParameter("balance");
        String tel =  req.getParameter("tel");
        String idNumber= req.getParameter("idNumber");

        Member member = new Member();
        long id1 = Long.parseLong(id);
        member.setId(id1);
        member.setName(name);
        long typeId1 = Long.parseLong(typeId);
        member.setTypeId(typeId1);
        double balance1=Double.parseDouble(balance);
        member.setBalance(balance1);
        member.setTel(tel);
        member.setIdNumber(idNumber);

        MembersService memberModify=  new MembersServiceImp();
        try {
            boolean isModified = memberModify.memberModify(member);
            req.setAttribute("member",member);
            if (isModified){
                req.setAttribute("success","Successfully updated");
                req.getRequestDispatcher("mem_modify.jsp").forward(req,resp);
            } else {
                req.setAttribute("error","Update failed, please try it again");
                req.getRequestDispatcher("mem_modify.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
