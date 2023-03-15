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

@WebServlet("/delBook")
public class delBookServlet extends HttpServlet {
    BookService bookService = new BookServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id= req.getParameter("id");
        Book book= new Book();
        book.setId(Long.parseLong(id));


        boolean isDel= false;
        try {
            isDel = bookService.delBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isDel){
            List<Book> books = null;
            try {
                books = bookService.getAllBooks();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allBooks",books);
            req.setAttribute("success","Successfully deleted!");
            req.getRequestDispatcher("book_list.jsp").forward(req,resp);

        } else{
            req.setAttribute("error","Operation failed, please try it again");
            req.getRequestDispatcher("book_list.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
