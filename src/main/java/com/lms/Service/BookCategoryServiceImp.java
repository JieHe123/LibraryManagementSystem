package com.lms.Service;

import com.lms.Bean.Type;
import com.lms.Dao.BookCategoryDao;
import com.lms.Dao.BookCateoryDaoImp;

import java.sql.SQLException;
import java.util.List;

public class BookCategoryServiceImp implements BookCategoryService {
    BookCategoryDao bookCategoryDao= new BookCateoryDaoImp();
    @Override
    public List<Type> getAllBookType() throws SQLException {
        return bookCategoryDao.getAllBookType();
    }

    @Override
    public boolean bookTypeModify(Type type) throws SQLException {
        return bookCategoryDao.bookTypeModify(type);
    }

    @Override
    public Type getTypeById(String id) throws SQLException {
        return bookCategoryDao.getTypeById(id);
    }

    @Override
    public boolean delBookServlet(Type bookType) throws SQLException {
        return bookCategoryDao.delBookType(bookType);
    }

    @Override
    public String addType(Type bookType) throws SQLException {
        return bookCategoryDao.addType(bookType);
    }
}
