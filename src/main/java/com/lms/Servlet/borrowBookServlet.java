package com.lms.Servlet;

import com.google.gson.Gson;
import com.lms.Bean.Book;
import com.lms.Bean.Member;
import com.lms.Bean.Type;
import com.lms.Service.*;
import com.sun.corba.se.impl.orbutil.ObjectWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/borrowBook")
public class borrowBookServlet extends HttpServlet {
    MembersService membersService = new MembersServiceImp();
    BookService bookService = new BookServiceImp();
    Member member= null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id=req.getParameter("memberId");
        member=membersService.getMemberById(id);
        if (member==null || member.getName()==null){
            member=new Member();
            member.setName("");
        }

        List<Book> books  = new ArrayList<>();
        req.setAttribute("member",member);
        req.setAttribute("books",books);
        req.getRequestDispatcher("book_rent.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String name=req.getParameter("bookContent");
        List<Book> books = null;
        try {
            books = bookService.getBookByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (member==null || member.getName()==null){
            member=new Member();
            member.setName("");
        }
//        req.setAttribute("member",member);
//        req.setAttribute("books",books);
        //req.getRequestDispatcher("book_rent.jsp").forward(req,resp);

        String booksJsonString = new Gson().toJson(books);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(booksJsonString);
        out.flush();

    }
}
