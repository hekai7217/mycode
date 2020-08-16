package com.sxt.test;

import com.sxt.controller.StuController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-14 14:12
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class TestLgoin {

    @Test
    public void login(){

        /**
         * 通过注解 实现了 相互依赖 实现了登陆的效果
         */
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        StuController stuController = app.getBean("stuController", StuController.class);
        stuController.login();


    }
}
