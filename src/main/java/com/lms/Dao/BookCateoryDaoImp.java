package com.lms.Dao;

import com.lms.Bean.MemberCombine;
import com.lms.Bean.Type;
import com.lms.Util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCateoryDaoImp implements BookCategoryDao{
    @Override
    public List<Type> getAllBookType() throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT * FROM type";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Type> allBookTypes  = new ArrayList<>();
        while (rs.next()){
            Type bookType= new Type();
            long id=rs.getLong("id");
            bookType.setId(id);
            String name=rs.getString("name");
            bookType.setName(name);
            long parentId=rs.getLong("parentId");
            bookType.setParentId(parentId);
            allBookTypes.add(bookType);
        }
        return allBookTypes;
    }

    @Override
    public boolean bookTypeModify(Type type) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="update type SET `name`=?, parentId=? WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,type.getName());
        statement.setLong(2,type.getParentId());
        statement.setLong(3,type.getId());
        int rs = statement.executeUpdate();
        return rs>0;
    }

    @Override
    public Type getTypeById(String idStr) throws SQLException {
        Type type= new Type();
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="select * from type where id="+idStr;
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            long id=rs.getLong("id");
            type.setId(id);
            String name=rs.getString("name");
            type.setName(name);
            long parentId=rs.getLong("parentId");
            type.setParentId(parentId);

        }
        return type;
    }

    @Override
    public boolean delBookType(Type bookType) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="DELETE from type WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,bookType.getId());

        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public String addType(Type bookType) throws SQLException {
        String existed="The id number is already existed, please input a new one";
        String success="Successfully added";
        String fail="Operation failed, please try again";
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT * from type where name =?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,bookType.getName());
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            return existed;
        }else{
            String sqlAdd = "INSERT into type(NAME,parentId) VALUES (?,?)";
            PreparedStatement statement1=jdbcConnection.prepareStatement(sqlAdd);
            statement1.setString(1,bookType.getName());
            statement1.setLong(2,bookType.getParentId());
            int rs1=statement1.executeUpdate();
            if (rs1>0){
                return success;
            } else {
                return fail;
            }
        }
    }
}
