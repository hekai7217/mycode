package com.sxt.demo01.test;

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

        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 可以id 或者name 获取对象
        User u1 = app.getBean("u1", User.class);
        System.out.println(u1);

        System.out.println("*****************");
        // 可以使用别名获取对象
        User u2 = app.getBean("user", User.class);
        System.out.println(u2);

    }

    @Test
    public void demo02(){
        // 测试 scope的配置
        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        User u2 = app.getBean("u2", User.class);
        System.out.println(u2.hashCode());

         User u3 = app.getBean("u2", User.class);
        System.out.println(u3.hashCode());


    }

}
