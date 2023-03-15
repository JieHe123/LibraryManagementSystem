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

@WebServlet("/delBookType")
public class delBookType extends HttpServlet {
    BookCategoryService bookCategoryService = new BookCategoryServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String id= req.getParameter("id");
        Type bookType= new Type();
        bookType.setId(Long.parseLong(id));


        boolean isDel= false;
        try {
            isDel = bookCategoryService.delBookServlet(bookType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isDel){
            List<Type> bookTypes = null;
            try {
                bookTypes = bookCategoryService.getAllBookType();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allBookTypes",bookTypes);
            req.setAttribute("success","Successfully deleted!");
            req.getRequestDispatcher("type_list.jsp").forward(req,resp);

        } else{
            req.setAttribute("error","Operation failed, please try it again");
            req.getRequestDispatcher("type_list.jsp").forward(req,resp);

        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
