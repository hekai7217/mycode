package com.sxt.test;

import com.sxt.jdk.JdkProxyHandler;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-15 9:57
 * @desc 百战程序员 http://www.itbaizhan.com
 *   jdk的动态代理缺陷:
 *     1. 必须实现接口   有些情况下 没有接口
 *           cglib 地方的动态代理解决方法
 *     2. 以 类为单位 , 所有的方法都代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    ApplicationContext app;

    @Test
    public void service(){

        // 获取动态代理对象
        JdkProxyHandler jdkProxyHandler = app.getBean("jdkProxyHandler", JdkProxyHandler.class);
        // UserServiceImpl传入真实对象  返回动态代理对象
        System.out.println(jdkProxyHandler);
        UserService jdkProxyObj = jdkProxyHandler.getJdkProxyObj(UserServiceImpl.class);
        // 调用方法
        // 方法都进行了增强   (有事务管理 )
        jdkProxyObj.update();
        System.out.println("***************");
        jdkProxyObj.insert();

        System.out.println("***************");
        jdkProxyObj.query();

        System.out.println("****************");
        jdkProxyObj.toString();

    }
}
