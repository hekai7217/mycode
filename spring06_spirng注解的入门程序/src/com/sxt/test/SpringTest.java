package com.sxt.test;

import com.sxt.bean.Person;
import com.sxt.bean.User;
import com.sxt.controller.StuController;
import com.sxt.controller.StuController02;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-14 9:40
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class SpringTest {

    @Test
    public void demo01(){

        // 拿到容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StuController stuController = app.getBean("stuController", StuController.class);
//        stuController.save();
//
        StuController stuController = app.getBean("stuCon", StuController.class);
        stuController.save();
    }

    @Test
    public void demo02(){

        // 拿到容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        StuController02 stuController = app.getBean("stuCon02", StuController02.class);
        stuController.save();
    }

    @Test
    public void demo03(){

        // 拿到容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = app.getBean("user", User.class);
        System.out.println(user.hashCode());

        User user2 = app.getBean("user", User.class);
        System.out.println(user2.hashCode());


    }

    @Test
    public void demo04(){

        // 拿到容器
        AbstractApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = app.getBean("person", Person.class);
        System.out.println(person);

        // 调用destory方法
        // 对象销毁   ioc关闭
        // ApplicationContext 接口没有关闭的方法
        // 他的子类或者 实现类 有关闭方法
        // AbstractApplicationContext 有关闭的方法
        app.close();

    }
}
