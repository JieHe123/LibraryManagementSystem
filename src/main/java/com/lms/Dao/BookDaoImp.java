package com.lms.Dao;

import com.lms.Bean.Book;
import com.lms.Bean.Type;
import com.lms.Util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao{
    @Override
    public List<Book> getAllBooks() throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT book.id,book.name,type.name AS typeName,book.price,book.`desc`,book.pic,book.publish," +
                "book.author,book.stock,book.address,book.typeId from book INNER JOIN type ON book.typeId=type.id";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Book> allBooks  = new ArrayList<>();
        while (rs.next()){
            Book book= new Book();
            long id = rs.getLong("id");
            String typeName=rs.getString("typeName");
            String name=rs.getString("name");
            double price=rs.getDouble("price");
            String desc=rs.getString("desc");
            String pic=rs.getString("pic");
            String  publish = rs.getString("publish");
            String author = rs.getString("author");
            long stock=rs.getLong("stock");
            String address=rs.getString("address");
            long typeId= rs.getLong("typeId");
            book.setId(id);
            Type bookType=new Type();
            bookType.setName(typeName);
            bookType.setId(typeId);
            book.setType(bookType);
            book.setName(name);
            book.setPrice(price);
            book.setDesc(desc);
            book.setPic(pic);
            book.setPublish(publish);
            book.setAuthor(author);
            book.setStock(stock);
            book.setAddress(address);
            allBooks.add(book);

        }
        return allBooks;
    }

    @Override
    public boolean bookModify(Book book) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="update book SET `name`=?, typeId=?,pic=?,stock=?,price=?,publish=?,author=?,address=?,`desc`=? WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,book.getName());
        statement.setLong(2,book.getTypeId());
        statement.setString(3,"Images/cover/"+book.getPic());
        statement.setLong(4,book.getStock());
        statement.setDouble(5,book.getPrice());
        statement.setString(6,book.getPublish());
        statement.setString(7,book.getAuthor());
        statement.setString(8,book.getAddress());
        statement.setString(9,book.getDesc());
        statement.setLong(10,book.getId());
        int rs = statement.executeUpdate();
        return rs>0;
    }

    @Override
    public Book getBookById(String idStr) throws SQLException {
        Book book= new Book();
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="select * from book where id="+idStr;
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            long id=rs.getLong("id");
            book.setId(id);
            String name=rs.getString("name");
            book.setName(name);
            long typeId=rs.getLong("typeId");
            book.setTypeId(typeId);
            String pic=rs.getString("pic");
            book.setPic(pic);
            long stock=rs.getLong("stock");
            book.setStock(stock);
            double price=rs.getDouble("price");
            book.setPrice(price);
            String publish=rs.getString("publish");
            book.setPublish(publish);
            String author = rs.getString("author");
            book.setAuthor(author);
            String address=rs.getString("address");
            book.setAddress(address);
            String desc=rs.getString("desc");
            book.setDesc(desc);


        }
        return book;
    }

    @Override
    public boolean delBook(Book book) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="DELETE from book WHERE id=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,book.getId());

        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public String addBook(Book book) throws SQLException {
        String existed="The id number is already existed, please input a new one";
        String success="Successfully added";
        String fail="Operation failed, please try again";
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="SELECT * from book where name =?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,book.getName());
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            return existed;
        }else{
            String sqlAdd = "INSERT INTO book(name,typeId,price,`desc`,publish,author,stock,address,pic) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement1=jdbcConnection.prepareStatement(sqlAdd);
            statement1.setString(1,book.getName());
            statement1.setLong(2,book.getTypeId());
            statement1.setDouble(3,book.getPrice());
            statement1.setString(4,book.getDesc());
            statement1.setString(5,book.getPublish());
            statement1.setString(6,book.getAuthor());
            statement1.setLong(7,book.getStock());
            statement1.setString(8,book.getAddress());
            statement1.setString(9,"Images/cover/"+book.getPic());

            int rs1=statement1.executeUpdate();
            if (rs1>0){
                return success;
            } else {
                return fail;
            }
        }
    }

    @Override
    public List<Book> getBookByName(String nameStr) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="select * from book where name LIKE '%"+nameStr+"%'";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Book book= new Book();
            long id=rs.getLong("id");
            book.setId(id);
            String name=rs.getString("name");
            book.setName(name);
            long typeId=rs.getLong("typeId");
            book.setTypeId(typeId);
            String pic=rs.getString("pic");
            book.setPic(pic);
            long stock=rs.getLong("stock");
            book.setStock(stock);
            double price=rs.getDouble("price");
            book.setPrice(price);
            String publish=rs.getString("publish");
            book.setPublish(publish);
            String author = rs.getString("author");
            book.setAuthor(author);
            String address=rs.getString("address");
            book.setAddress(address);
            String desc=rs.getString("desc");
            book.setDesc(desc);
            books.add(book);


        }
        return books;
    }

    @Override
    public boolean delStock(Book book) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="UPDATE book SET stock=stock-1 WHERE `id`=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,book.getId());
        int rs=statement.executeUpdate();
        return rs>0;
    }

    @Override
    public boolean updateStock(long bookId) throws SQLException {
        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql="UPDATE book SET stock=stock+1 WHERE `id`=?";
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setLong(1,bookId);
        int rs=statement.executeUpdate();
        return rs>0;
    }


}
