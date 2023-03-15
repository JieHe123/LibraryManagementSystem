package com.lms.Servlet;

import com.lms.Bean.Book;
import com.lms.Bean.Type;
import com.lms.Service.BookCategoryService;
import com.lms.Service.BookCategoryServiceImp;
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

@WebServlet("/addBook")
public class addBookServlet extends HttpServlet {
    BookCategoryService bookCategoryService= new BookCategoryServiceImp();
    BookService bookService=new BookServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allTypes",bookTypes);
        req.getRequestDispatcher("book_add.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Book book=new Book();
        String name = req.getParameter("name");
        String typeId=req.getParameter("typeId");
        String pic = req.getParameter("pic");
        String stock=req.getParameter("stock");
        String price=req.getParameter("price");
        String publish=req.getParameter("publish");
        String author=req.getParameter("author");
        String address=req.getParameter("address");
        String desc=req.getParameter("desc");

        book.setName(name);
        book.setTypeId(Long.parseLong(typeId));
        book.setPic(pic);
        book.setStock(Long.parseLong(stock));
        book.setPrice(Double.parseDouble(price));
        book.setPublish(publish);
        book.setAuthor(author);
        book.setAddress(address);
        book.setDesc(desc);

        String isAdded="";

        try {
            isAdded = bookService.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allTypes",bookTypes);
        req.setAttribute("state",isAdded);
        req.getRequestDispatcher("book_add.jsp").forward(req,resp);
    }
}
