package com.lms.Dao;

import com.lms.Bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getAllBooks() throws SQLException;
    boolean bookModify(Book book) throws SQLException;
    Book getBookById(String id) throws SQLException;
    boolean delBook(Book book) throws SQLException;
    String addBook(Book book) throws SQLException;
    List<Book> getBookByName(String name) throws SQLException;
    boolean delStock(Book book) throws SQLException;
    boolean  updateStock(long bookId) throws SQLException;
}
