package com.lms.Dao;

import com.lms.Bean.Member;
import com.lms.Bean.MemberCombine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MembersDao {
    List<MemberCombine> getAllMembers() throws SQLException;
    boolean memberModify(Member member) throws SQLException;

    Member getMemberById(String id);
    Member getMemberByIdNumber(String idNumber);

    boolean topup(Member member) throws SQLException;

    String addMember(Member member) throws SQLException;
    boolean delMember(Member member) throws SQLException;
    boolean updateBalance(long memberId, double balance) throws SQLException;


}
