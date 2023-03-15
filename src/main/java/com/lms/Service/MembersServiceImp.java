package com.lms.Service;

import com.lms.Bean.Member;
import com.lms.Bean.MemberCombine;
import com.lms.Dao.MembersDao;
import com.lms.Dao.MembersDaoImp;

import java.sql.SQLException;
import java.util.List;

public class MembersServiceImp implements MembersService {
    MembersDao getAllMemberDao = new MembersDaoImp();
    @Override
    public List<MemberCombine> getAllMembers() throws SQLException {
        return getAllMemberDao.getAllMembers();
    }
    @Override
    public boolean memberModify(Member member) throws SQLException {
        return getAllMemberDao.memberModify(member);

    }

    @Override
    public Member getMemberById(String id) {
        return getAllMemberDao.getMemberById(id);
    }

    @Override
    public Member getMemberByIdNumber(String idNumber) {
        return getAllMemberDao.getMemberByIdNumber(idNumber);
    }

    @Override
    public boolean topup(Member member) throws SQLException {
        return getAllMemberDao.topup(member);
    }

    @Override
    public String addMember(Member member) throws SQLException {
        return getAllMemberDao.addMember(member);
    }

    @Override
    public boolean delMember(Member member) throws SQLException {
        return getAllMemberDao.delMember(member);
    }
}
