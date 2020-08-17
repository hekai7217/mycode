package com.sxt.service.impl;

import com.sxt.dao.AccountDaoImpl;
import com.sxt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黄药师
 * @date 2020-08-17 9:36
 * @desc 百战程序员 http://www.itbaizhan.com
 * <p>
 * 如果在 Service管理事务:
 * //开始
 * // 把2个db操作 进行事务管理
 * // 提交和回滚
 * <p>
 * 在service 层 管理事务 可以直接用aop操作
 * *      (不在修改原来的代码基础上 进行方法的增强(事务管理))
 * <p>
 * *
 */
@Service
//@Transactional(
//        isolation = Isolation.DEFAULT , //配置事务隔离级别
//        propagation = Propagation.REQUIRED , //配置事务传播行为
//)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoImpl accountDao;

    /* @Transactional
    * 贴上此当前类已经被Spring事务管理
    * 注意： @Transactional 只能对当前贴的Service类有效
    *  常用属性 ：
    *  	isolation=Isolation.REPEATABLE_READ,  隔离级别
		propagation=Propagation.REQUIRED,传播规则
		readOnly=true 是否只读事务
    */

    // 这个方法使用了  spring进行事务管理
    @Transactional(
            isolation = Isolation.DEFAULT , //配置事务隔离级别
            propagation = Propagation.REQUIRED //配置事务传播行为
    )
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
