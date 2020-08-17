package com.sxt.service.impl;

import com.sxt.dao.AccountDaoImpl;
import com.sxt.service.AccountService;

/**
 * @author 黄药师
 * @date 2020-08-17 9:36
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    如果在 Service管理事务:
 *         //开始
 *         // 把2个db操作 进行事务管理
 *         // 提交和回滚
 *
 *    在service 层 管理事务 可以直接用aop操作
 *  *      (不在修改原来的代码基础上 进行方法的增强(事务管理))
 *
 *  *
 */
public class AccountServiceImpl implements AccountService {

    private AccountDaoImpl accountDao;

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    /**
     *  转账的业务
     */
    @Override
    public void transfer(String outName,String inName,int money) {


        //开始

        // 把2个db操作 进行事务管理

        // 提交和回滚

        // 操作数据库 2次
        // a 的钱 减少了
        accountDao.transferOut(outName,money);

        //没有事务管理  数据库的数据有问题
        int a = 10 / 0 ;

        // b 的钱增加了
        accountDao.transferIn(inName,money);

    }
}
