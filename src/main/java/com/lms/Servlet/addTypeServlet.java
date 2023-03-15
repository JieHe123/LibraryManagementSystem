package com.lms.Servlet;

import com.lms.Bean.Type;
import com.lms.Service.BookCategoryService;
import com.lms.Service.BookCategoryServiceImp;
import sun.util.resources.ga.LocaleNames_ga;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addBookType")
public class addTypeServlet extends HttpServlet {
    BookCategoryService bookCategoryService = new BookCategoryServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<Type> bookTypes= null;
            try {
            bookTypes = bookCategoryService.getAllBookType();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allTypes",bookTypes);
        req.getRequestDispatcher("type_add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Type bookType=new Type();
        String name = req.getParameter("cat_name");
        String parentId=req.getParameter("parentId");
        bookType.setName(name);
        bookType.setParentId(Long.parseLong(parentId));
        String isAdded="";

        try {
            isAdded = bookCategoryService.addType(bookType);
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
        req.getRequestDispatcher("type_add.jsp").forward(req,resp);
    }
}
