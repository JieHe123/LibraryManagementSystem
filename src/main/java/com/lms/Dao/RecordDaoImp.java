package com.lms.Dao;

import com.lms.Bean.Book;
import com.lms.Bean.Record;
import com.lms.Bean.RecordCombine;
import com.lms.Util.JDBCHelper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImp implements RecordDao {
    @Override
    public boolean addRecord(Record record) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="INSERT into record(memberId,bookId,rentDate,backDate,deposit,userId,isbn) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,record.getMemberId());
        statement.setLong(2,record.getBookId());
        statement.setDate(3,record.getRentDate());
        statement.setDate(4,record.getBackDate());
        statement.setDouble(5,record.getDeposit());
        statement.setLong(6,record.getUserId());
        statement.setString(7,record.getIsbn());
        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public List<RecordCombine> getRecordByMemberId(String memberId) throws SQLException {
        List<RecordCombine> records= new ArrayList<>();
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT record.`id`,bookId,memberId,`status`,book.`name` as name,record.rentDate,record.backDate,record.isbn,book.publish,book.address as address,book.price as price FROM book INNER JOIN record " +
                "ON record.bookId=book.id WHERE record.memberId="+memberId;
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            RecordCombine recordCombine = new RecordCombine();
            long recordId=rs.getLong("id");
            recordCombine.setId(recordId);
            recordCombine.setBookId(rs.getLong("bookId"));
            recordCombine.setMemberId(rs.getLong("memberId"));
            recordCombine.setStatus(rs.getString("status"));
            String bookName=rs.getString("name");
            recordCombine.setBookName(bookName);
            String isbn=rs.getString("isbn");
            recordCombine.setIsbn(isbn);
            java.sql.Date rentDate=rs.getDate("rentDate");
            recordCombine.setRentDate(rentDate);
            Date backDate=rs.getDate("backDate");
            recordCombine.setBackDate(backDate);
            String publish=rs.getString("publish");
            recordCombine.setPublish(publish);
            String address=rs.getString("address");
            recordCombine.setAddress(address);
            double price=rs.getDouble("price");
            recordCombine.setPrice(price);
            records.add(recordCombine);

        }
        return records;
    }

    @Override
    public int updateActualReturnDateAndStatus(long recordId) throws SQLException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date actualBackDate = new Date(System.currentTimeMillis());
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql2="SELECT backDate,rentDate FROM record WHERE id=?";
        PreparedStatement statement2=jdbcConnection.prepareStatement(sql2);
        statement2.setLong(1,recordId);
        ResultSet rs2 = statement2.executeQuery();
        Date backDate=null;
        Date rentDate=null;

        while(rs2.next()){
            backDate =rs2.getDate("backDate");
            rentDate =rs2.getDate("rentDate");
        }
        String status="";
        assert backDate != null;
        if(actualBackDate.compareTo(backDate) <=0) {
            status="Normal Return";
        } else if (actualBackDate.compareTo(backDate) >0){
            status="Late Return";
        }

        String sql="UPDATE record SET actualBackDate=?,status=? where id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setDate(1,actualBackDate);
        statement.setString(2,status);
        statement.setLong(3,recordId);
        int rs=statement.executeUpdate();
        return (int)((actualBackDate.getTime()-rentDate.getTime())/1000/60/60/24);
    }




}
