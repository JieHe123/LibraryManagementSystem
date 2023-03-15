package com.lms.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCHelper {
    public static Connection JDBCConnection()  {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", "root");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
