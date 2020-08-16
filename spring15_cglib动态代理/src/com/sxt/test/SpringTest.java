package com.sxt.test;

import com.sxt.cglib.CglibProxyHandler;
import com.sxt.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.xml.PlatformXmlPropertiesProvider;

/**
 * @author 黄药师
 * @date 2020-08-15 9:57
 * @desc 百战程序员 http://www.itbaizhan.com
 *   jdk的动态代理缺陷:
 *     1. 必须实现接口   有些情况下 没有接口
 *           cglib 地方的动态代理解决方法
 *     2. 以 类为单位 , 所有的方法都代理
 *           这个不好, 对指定的方法 进行增强  (springaop来解决)
 *
 *       Cglib 基于 继承来实现 方法的增强?
 *          1. 如果你的方法 是final / static / private 就不能实现增强
 *              oop 中  final 和 static  private 方法 不能被重写
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    CglibProxyHandler handler;

    @Test
    public void service(){

        // 获取动态代理类型
        UserServiceImpl proxyObj = handler.getProxyObj(UserServiceImpl.class);

        //调用方法
        proxyObj.insert();

        System.out.println("*************");
        proxyObj.update();

        System.out.println("&&&&&&&&&&&&&&&");
        proxyObj.toString();

    }
}
