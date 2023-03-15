package com.lms.Service;

import com.lms.Bean.Book;
import com.lms.Bean.RecordCombine;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks() throws SQLException;
    boolean bookModify(Book book) throws SQLException;
    Book getBookById(String id) throws SQLException;
    boolean delBook(Book book) throws SQLException;
    String addBook(Book book) throws SQLException;
    List<Book> getBookByName(String name) throws SQLException;
    boolean borrowBook(long id, List<Long> bookIdList) throws SQLException;
    boolean returnBook(long bookId, long memberId,long recordId) throws SQLException;
}
