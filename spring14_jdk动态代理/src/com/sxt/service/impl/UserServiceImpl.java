package com.sxt.service.impl;

import com.sxt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 黄药师
 * @date 2020-08-15 9:50
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Service
public class UserServiceImpl implements UserService {


    /**
     * 事务操作:
     * 开启
     * 提交
     * 回滚
     * 关闭session
     */
    @Override
    public void insert() {

        System.out.println("UserServiceImpl.insert");

    }

    @Override
    public void update() {

        System.out.println("UserServiceImpl.update");

    }

    @Override
    public void query() {
        System.out.println("UserServiceImpl.query");
    }
}
