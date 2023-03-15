package com.lms.Dao;

import com.lms.Bean.Member;
import com.lms.Bean.MemberCombine;
import com.lms.Util.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembersDaoImp implements MembersDao {
    @Override
    public List<MemberCombine> getAllMembers() throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="select member.id,member.`name`,member.tel,membertype.`name` as typeName," +
                "member.balance,member.regdate,member.idNumber from member INNER JOIN membertype on " +
                "member.typeId=membertype.id";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<MemberCombine> allMembers  = new ArrayList<>();

        while(rs.next()){
            MemberCombine member = new MemberCombine();
            long id=rs.getLong("id");
            member.setId(id);
            String name=rs.getString("name");
            member.setName(name);
            String tel=rs.getString("tel");
            member.setTel(tel);
            String typeName= rs.getString("typeName");
            member.setTypeName(typeName);
            double balance=rs.getDouble("balance");
            member.setBalance(balance);
            Date regdate=rs.getDate("regdate");
            member.setRegdate(regdate);
            String idNumber=rs.getString("idNumber");
            member.setIdNumber(idNumber);
            allMembers.add(member);
        }
        return allMembers;
    }
    @Override
    public Member getMemberById(String idstr) {

        Member member = new Member();
        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="select * from member where id="+idstr;
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            long id=rs.getLong("id");
            member.setId(id);
            String name=  rs.getString("name");
            member.setName(name);
            String tel=rs.getString("tel");
            member.setTel(tel);
            long typeId= rs.getLong("typeId");
            member.setTypeId(typeId);
            double balance=rs.getDouble("balance");
            member.setBalance(balance);
            Date regdate=rs.getDate("regdate");
            member.setRegdate(regdate);
            String idNumber=rs.getString("idNumber");
            member.setIdNumber(idNumber);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public Member getMemberByIdNumber(String idNumberStr) {
        Member member = new Member();
        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql="select * from member where idNumber="+idNumberStr;
            PreparedStatement statement=jdbcConnection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                long id=rs.getLong("id");
                member.setId(id);
                String name=  rs.getString("name");
                member.setName(name);
                String tel=rs.getString("tel");
                member.setTel(tel);
                long typeId= rs.getLong("typeId");
                member.setTypeId(typeId);
                double balance=rs.getDouble("balance");
                member.setBalance(balance);
                Date regdate=rs.getDate("regdate");
                member.setRegdate(regdate);
                String idNumber=rs.getString("idNumber");
                member.setIdNumber(idNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }


    @Override
    public boolean memberModify(Member member) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="UPDATE member SET name =?,typeId=?,balance=?,tel=?,idNumber=? WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,member.getName());
        statement.setLong(2,member.getTypeId());
        statement.setDouble(3,member.getBalance());
        statement.setString(4,member.getTel());
        statement.setString(5,member.getIdNumber());
        statement.setLong(6,member.getId());

        int rs = statement.executeUpdate();
        return rs>0;
    }
    @Override
    public boolean topup(Member member) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="update member SET balance=balance+? WHERE  idNumber=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setDouble(1,member.getBalance());
        statement.setString(2,member.getIdNumber());

        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public String addMember(Member member) throws SQLException {
        String existed="The id number is already existed, please input a new one";
        String success="Successfully added";
        String fail="Operation failed, please try again";
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT * from member where idNumber=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,member.getIdNumber());
        ResultSet rs = statement.executeQuery();

        if (rs.next()){
            return existed;
        }else{
            String sqlAdd = "INSERT into member(NAME,pwd,typeId,balance,tel,idNumber) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement1=jdbcConnection.prepareStatement(sqlAdd);
            statement1.setString(1,member.getName());
           statement1.setString(2, member.getPwd());
            statement1.setLong(3,member.getTypeId());
            statement1.setDouble(4,member.getBalance());
            statement1.setString(5,member.getTel());
            statement1.setString(6,member.getIdNumber());

            int rs1=statement1.executeUpdate();
            if (rs1>0){
                return success;
            } else {
                return fail;
            }
        }

    }

    @Override
    public boolean delMember(Member member) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="DELETE from member WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,member.getId());

        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public boolean updateBalance(long memberId, double balance) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="UPDATE member SET balance=? WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,memberId);
        statement.setDouble(2,balance);

        int rs=statement.executeUpdate();
        return rs>0;
    }


}
