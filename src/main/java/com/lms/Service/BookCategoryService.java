package com.lms.Service;

import com.lms.Bean.Type;

import java.sql.SQLException;
import java.util.List;

public interface BookCategoryService {
    List<Type> getAllBookType() throws SQLException;
    boolean bookTypeModify(Type type) throws SQLException;
    Type getTypeById(String id) throws SQLException;
    boolean delBookServlet(Type bookType) throws SQLException;
    String addType(Type bookType) throws SQLException;
}
