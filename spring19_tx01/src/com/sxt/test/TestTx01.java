package com.sxt.test;

import com.sxt.service.AccountService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-17 9:45
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx01 {

    @Autowired
    private AccountService accountService;

    /**
     *  业务进行 数据库的更新操作  如果没有事务管理   数据的数据不安全
     *
     *  解决:在 业务层进行 事务管理
     *
     *   spring 的事务管理就是 通过aop操作 在service 添加 事务管理
     */
    @Test
    public void trano1(){
        accountService.transfer("aa","bb",100);
    }

}
