package com.lms.Service;

import com.lms.Bean.RecordCombine;
import com.lms.Dao.RecordDao;
import com.lms.Dao.RecordDaoImp;

import java.sql.SQLException;
import java.util.List;

public class RecordServiceImp implements RecordService{
    RecordDao recordDao = new RecordDaoImp();
    @Override
    public List<RecordCombine> getRecordByMemberId(String memberId) throws SQLException {
        return recordDao.getRecordByMemberId(memberId);
    }
}
