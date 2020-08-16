package com.sxt.service.impl;

import com.sxt.service.UserService;

/**
 * @author 黄药师
 * @date 2020-08-15 9:50
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class UserServiceImpl implements UserService {

    @Override
    public void insert() {

        System.out.println("UserServiceImpl.insert");

    }

    @Override
    public void update() {
        System.out.println("UserServiceImpl.update");
        int a = 10 / 0 ;

    }

    @Override
    public void query() {
        System.out.println("UserServiceImpl.query");
    }
}
