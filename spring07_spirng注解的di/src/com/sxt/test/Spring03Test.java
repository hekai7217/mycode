package com.sxt.test;


import com.sxt.bean.Person;
import com.sxt.bean.User;
import com.sxt.controller.StuController01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-14 9:40
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   测试 @value注解
 */
public class Spring03Test {

    @Test
    public void demo01(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = app.getBean("user", User.class);

        System.out.println(user);

    }

    @Test
    public void demo02(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person p = app.getBean("person", Person.class);

        // ioc没有 添加 p.properties文件   User{name='${p.name}', age='${p.age}'}
        System.out.println(p);

    }
}
