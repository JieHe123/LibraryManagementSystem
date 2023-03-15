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

@WebServlet("/bookModify")
public class bookModifyServlet extends HttpServlet {
    BookService bookService =new BookServiceImp();
    BookCategoryService bookCategoryService = new BookCategoryServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id=req.getParameter("id");
        Book book= null;
        try {
            book = bookService.getBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("book",book);
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("bookTypes",bookTypes);
        req.getRequestDispatcher("book_modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String typeId=req.getParameter("typeId");
        String filePic=req.getParameter("filePic");
        String stock=req.getParameter("stock");
        String price=req.getParameter("price");
        String publish=req.getParameter("publish");
        String author=req.getParameter("author");
        String address=req.getParameter("address");
        String desc=req.getParameter("desc");
        Book book = new Book();
        book.setId(Long.parseLong(id));
        book.setName(name);
        book.setTypeId(Long.parseLong(typeId));
        book.setPic(filePic);
        book.setStock(Long.parseLong(stock));
        book.setPrice(Double.parseDouble(price));
        book.setPublish(publish);
        book.setAuthor(author);
        book.setAddress(address);
        book.setDesc(desc);
        boolean isModified = false;
        List<Book> allBooks= null;
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("bookTypes",bookTypes);
        try {

            isModified = bookService.bookModify(book);
            req.setAttribute("book",book);
            if (isModified){

                req.setAttribute("success","Successfully updated");
                req.getRequestDispatcher("book_modify.jsp").forward(req,resp);

            } else {

                req.setAttribute("error","Update failed, please try it again");
                req.getRequestDispatcher("book_modify.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
