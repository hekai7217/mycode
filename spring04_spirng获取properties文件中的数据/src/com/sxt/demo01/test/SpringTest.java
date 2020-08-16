package com.sxt.demo01.test;

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
 *   spring可以 获取 xxx.properties 配置文件的数据
 *
 *   需要导入一个 context的命名空间
 *   添加新的命名空间
 *
 *   配置db.proper贴上
 *
 *   配置 连接池的注入
 *
 *   获取连接池的对象
 */
public class SpringTest {

    @Test
    public void demo01(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = app.getBean("dataSource", DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
