package com.sxt.demo01.service.impl;

import com.sxt.demo01.dao.UserDao;
import com.sxt.demo01.service.Userservice;

/**
 * @author 黄药师
 * @date 2020-08-12 16:21
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class UserServiceImpl implements Userservice {

    private  UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(String name, String pwd) {

        // 以前
//        UserDao userDao = new UserDao();
//        userDao.register(xxx);

        // 用spring来管理这种依赖关系
        userDao.register(name,pwd);

    }


}
