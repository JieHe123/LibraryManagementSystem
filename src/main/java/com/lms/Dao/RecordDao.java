package com.lms.Dao;

import com.lms.Bean.Record;
import com.lms.Bean.RecordCombine;

import java.sql.SQLException;
import java.util.List;

public interface RecordDao {
    boolean addRecord(Record record) throws SQLException;
    List<RecordCombine> getRecordByMemberId(String memberId) throws SQLException;
    int updateActualReturnDateAndStatus(long recordId) throws SQLException;

}