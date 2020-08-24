package com.sxt.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 黄药师
 * @date 2020-08-24 10:22
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class TestConn {

    /**
     *  环境搭建步骤:
     *    1. 准备数据库 (sql文件导入到 数据库中 )
     *    2. 创建项目和导入需要的jar
     *    3. 添加配置文件
     *    4. mybatis-plus的代码生成器 执行
     *    5. 测试数据库文件是否能连接
     */
    @Test
    public void testConn(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = app.getBean("dataSource", DataSource.class);

        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
