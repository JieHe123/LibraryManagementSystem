package com.lms.Servlet;

import com.lms.Bean.Member;
import com.lms.Bean.Type;
import com.lms.Service.BookCategoryService;
import com.lms.Service.BookCategoryServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookTypeModify")
public class bookTypeModifyServlet extends HttpServlet {
    BookCategoryService bookCategoryService = new BookCategoryServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id=req.getParameter("id");
        Type bookType= null;
        try {
            bookType = bookCategoryService.getTypeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("bookType",bookType);
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allTypes",bookTypes);
        req.getRequestDispatcher("type_modify.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id=req.getParameter("typeId");
        String name=req.getParameter("typeName");
        String parentId=req.getParameter("parentType");
        Type bookType = new Type();
        bookType.setId(Long.parseLong(id));
        bookType.setName(name);
        bookType.setParentId(Long.parseLong(parentId));
        boolean isModified = false;
        List<Type> bookTypes= null;
        try {
            bookTypes = bookCategoryService.getAllBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allTypes",bookTypes);
        try {

            isModified = bookCategoryService.bookTypeModify(bookType);
            req.setAttribute("bookType",bookType);
            if (isModified){

                req.setAttribute("success","Successfully updated");
                req.getRequestDispatcher("type_modify.jsp").forward(req,resp);

            } else {

                req.setAttribute("error","Update failed, please try it again");
                req.getRequestDispatcher("type_modify.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
