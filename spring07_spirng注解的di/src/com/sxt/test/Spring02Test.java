package com.sxt.test;


import com.sxt.controller.StuController01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-14 9:40
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   测试 @Resource 的注解
 */
public class Spring02Test {

    @Test
    public void demo01(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuController01 stuController01 = app.getBean("stuController01", StuController01.class);
        stuController01.save();

    }
}
