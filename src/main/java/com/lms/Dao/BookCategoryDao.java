package com.lms.Dao;

import com.lms.Bean.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BookCategoryDao {
    List<Type> getAllBookType() throws SQLException;
    boolean bookTypeModify(Type type) throws SQLException;
    Type getTypeById(String id) throws SQLException;
    boolean delBookType(Type bookType) throws SQLException;
    String addType(Type bookType) throws SQLException;

}
