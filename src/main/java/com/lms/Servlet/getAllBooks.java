package com.lms.Servlet;

import com.lms.Bean.Book;
import com.lms.Bean.Type;
import com.lms.Service.BookService;
import com.lms.Service.BookServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getAllBooks")
public class getAllBooks extends HttpServlet {
    BookService bookService = new BookServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<Book> allBooks = null;
        try {
            allBooks = bookService.getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allBooks",allBooks);
        req.getRequestDispatcher("book_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
