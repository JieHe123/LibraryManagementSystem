package com.lms.Service;

import com.lms.Bean.RecordCombine;

import java.sql.SQLException;
import java.util.List;

public interface RecordService {
    List<RecordCombine> getRecordByMemberId(String memberId) throws SQLException;
}
