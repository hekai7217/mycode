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
 *
 *     spring管理事务的操作:
 *       1. 导入包
 *            spring的核心包  4个
 *            spring的aop包   3个
 *                 aop包 aspect 包 织入包
 *            日志包  commons-loggin
 *            事务的包:
 *                spring-jdbc包
 *                spring-tx的事务包
 *            数据库的包:
 *               数据库连接池
 *               数据库驱动包
 *      2. 配置
 *          1. 引入 aop / tx事务的命令空间
 *
 *          2. 配置事务管理器
 *
 *             jdbc/mybatis
 *             <bean class="DataSoruceTransactionManager"></bean>
 *
 *
 *          3. aop配置事务
 *
 *
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx01 {

    @Autowired
    private AccountService accountService;

    /**
     *
     *    加了 spring管理事务
     *       方法中如果出现了 异常  进行事务管理  数据库的数据安全

     */
    @Test
    public void trano1(){
        accountService.transfer("aa","bb",100);
    }

}
