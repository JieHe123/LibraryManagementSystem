package com.lms.Servlet;

import com.lms.Bean.Book;
import com.lms.Service.BookService;
import com.lms.Service.BookServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doBorrowBook")
public class doBorrowBookServlet  extends HttpServlet {
    BookService bookService = new BookServiceImp();
    List<String> ids=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String checked=req.getParameter("checked");
        if("true".equals(checked)){
            ids.add(id);
        }else{
            ids.remove(id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("memberId");
        long memberId=Long.parseLong(id);
        List<Long> bookList= new ArrayList<>();
        for (int i=0;i<ids.size();i++){
            bookList.add(Long.parseLong(ids.get(i)));
        }
        try {
            bookService.borrowBook(memberId,bookList);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
