package com.sxt.demo01.test;

import com.sxt.demo01.bean.Person;
import com.sxt.demo01.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-12 11:12
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Spring01Test {

    @Test
    public void demo01(){
        // 测试 di的配置
        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        User u1 = app.getBean("u1", User.class);
        System.out.println(u1);
    }

    @Test
    public void demo02(){
        // 测试 di的配置
        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        User u2 = app.getBean("u2", User.class);
        System.out.println(u2);
        System.out.println(u2.getCar());
        System.out.println(u2.getDate());
    }

    @Test
    public void demo03(){
        // 测试 di的配置
        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // di的构造器的注入
        Person p1 = app.getBean("p1", Person.class);
        System.out.println(p1);

    }

    @Test
    public void demo04(){
        // 测试 di的配置
        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // di的构造器的注入
        Person p2 = app.getBean("p2", Person.class);
        System.out.println(p2);
        System.out.println(p2.getCar());
    }

}
