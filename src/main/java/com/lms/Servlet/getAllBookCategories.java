package com.lms.Servlet;

import com.lms.Bean.MemberCombine;
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
import java.util.List;

@WebServlet("/getAllBookTypes")
public class getAllBookCategories extends HttpServlet {
    BookCategoryService bookCategoryService =  new BookCategoryServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<Type> allBookTypes = null;
        try {
            allBookTypes = bookCategoryService.getAllBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allBookTypes",allBookTypes);
        req.getRequestDispatcher("type_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

    }
}
