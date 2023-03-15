package com.lms.Service;

import com.lms.Bean.Book;
import com.lms.Bean.Record;
import com.lms.Dao.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImp implements BookService{
    BookDao bookDao=new BookDaoImp();
    MembersDao membersDao =new MembersDaoImp();
    RecordDao recordDao = new RecordDaoImp();
    @Override
    public List<Book> getAllBooks() throws SQLException {
        return bookDao.getAllBooks();
    }

    @Override
    public boolean bookModify(Book book) throws SQLException {
        return bookDao.bookModify(book);
    }

    @Override
    public Book getBookById(String id) throws SQLException {
        return bookDao.getBookById(id);
    }

    @Override
    public boolean delBook(Book book) throws SQLException {
        return bookDao.delBook(book);
    }

    @Override
    public String addBook(Book book) throws SQLException {
        return bookDao.addBook(book);
    }

    @Override
    public List<Book> getBookByName(String name) throws SQLException {
        return bookDao.getBookByName(name);
    }

    @Override
    public boolean borrowBook(long id, List<Long> bookIdList) throws SQLException {
        //delete stock
        for (int i=0;i<bookIdList.size();i++){
            Book book = new Book();
            book.setId(bookIdList.get(i));
            bookDao.delStock(book);

        }



        //add record
        for (int i=0;i<bookIdList.size();i++) {
            Record record = new Record();
            record.setMemberId(id);
            record.setBookId(bookIdList.get(i));
            record.setRentDate(new Date(2023,02,06));
            record.setUserId(1);
            record.setIsbn("1414-142414-312");
            recordDao.addRecord(record);

        }




        return true;
    }

    @Override
    public boolean returnBook(long bookId, long memberId, long recordId) throws SQLException {
        double rentPricePerDay=1;
        int totalRentDays = recordDao.updateActualReturnDateAndStatus(recordId);
        double balance = totalRentDays * rentPricePerDay;
        boolean res=false;
        res= membersDao.updateBalance(memberId, balance);
        res = bookDao.updateStock(bookId);

        return res;
    }


}
