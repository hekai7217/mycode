package com.sxt.test;

import com.sxt.bean.User;
import com.sxt.config.SpringConfig;
import com.sxt.controller.StuController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 黄药师
 * @date 2020-08-14 14:12
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class TestLgoin {

    @Test
    public void login(){

        //纯注解开发
        // AnnotationConfigApplicationContext 这个实现的实现类型 创建 ioc容器
        // 通过 Configuration 标签的 类创建一个ioc容器
        ApplicationContext app =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        StuController stuContoller = app.getBean("stuController", StuController.class);
        stuContoller.login();

    }

    @Test
    public void demo01(){

        //纯注解开发
        // AnnotationConfigApplicationContext 这个实现的实现类型 创建 ioc容器
        // 通过 Configuration 标签的 类创建一个ioc容器
        ApplicationContext app =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        User bean = app.getBean("user",User.class);
        System.out.println(bean);
    }

    @Test
    public void demo02(){

        //纯注解开发
        // AnnotationConfigApplicationContext 这个实现的实现类型 创建 ioc容器
        // 通过 Configuration 标签的 类创建一个ioc容器
        ApplicationContext app =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = app.getBean("dataSource", DataSource.class);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
