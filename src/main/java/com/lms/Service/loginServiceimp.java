package com.lms.Service;

import com.lms.Dao.loginDao;
import com.lms.Dao.loginDaoImp;

public class loginServiceimp implements loginService{
    loginDao ld= new loginDaoImp();

    @Override
    public boolean login(String username, String pwd) throws Exception {

        return ld.login(username,pwd);
    }
}
