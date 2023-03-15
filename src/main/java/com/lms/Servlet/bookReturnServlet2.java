package com.lms.Servlet;

import com.lms.Bean.Member;
import com.lms.Bean.RecordCombine;
import com.lms.Service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/returnBook2")
public class bookReturnServlet2 extends HttpServlet {
    BookService bookService = new BookServiceImp();
    MembersService membersService = new MembersServiceImp();
    RecordService recordService = new RecordServiceImp();
    Member member= null;
    List<RecordCombine> recordCombines= new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        long memberId = Long.parseLong(req.getParameter("memberId"));
        long bookId=Long.parseLong(req.getParameter("bookId"));
        long recordId=Long.parseLong(req.getParameter("recordId"));
        boolean isreturned=false;

        try {
            isreturned=bookService.returnBook(bookId,memberId,recordId);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id=req.getParameter("memberId");
        member=membersService.getMemberById(id);
        if (member==null || member.getName()==null){
            member=new Member();
            member.setName("");
        }

        try {
            recordCombines = recordService.getRecordByMemberId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("member",member);
        req.setAttribute("recordCombines",recordCombines);
        if (isreturned){

            req.setAttribute("success","Successfully returned");
            req.getRequestDispatcher("return_list.jsp").forward(req,resp);

        } else {

            req.setAttribute("error","Update failed, please try it again");
            req.getRequestDispatcher("return_list.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
