package com.sxt.demo01.test;

import com.sxt.demo01.controller.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 黄药师
 * @date 2020-08-12 15:44
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   写一个简单的程序 模拟登陆操作:
 *      1. controller 层
 *      2. service层
 *      3 dao层
 *     层于层之间的依赖关系 交给spring管理

 *     spring和javaWeb项目的整合 (和上面的案例不一样)
 *
 */
public class SpringTest {

    @Test
    public void demo01(){

        //获取容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取controller对象
        UserServlet userController = app.getBean("userController", UserServlet.class);
        userController.service();

    }
}
