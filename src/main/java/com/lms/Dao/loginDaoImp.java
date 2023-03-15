package com.lms.Dao;

import com.lms.Util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDaoImp implements loginDao{
    @Override
    public boolean login(String username, String pwd) throws Exception {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT * FROM `user` WHERE `name`='"+ username +"'AND pwd='"+ pwd+"'";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        return rs.next();

    }
}
