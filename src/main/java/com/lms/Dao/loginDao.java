package com.lms.Dao;

import java.sql.SQLException;

public interface loginDao {
    boolean login(String username,String pwd) throws SQLException, ClassNotFoundException, Exception;
}
