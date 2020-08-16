package com.sxt.test;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-14 15:23
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *     springjdbc模块的介绍:
 *
 *     1. 需要添加jar
 *       spring-jdbc 对jdbc的支持 / spring-tx spring的事务管理
 *
 *     2. 需要配置数据库连接操作
 *        dateSource
 *
 *     3. 配置 spring提供的jdbc的模板
 *             对jdbc进行的封装
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 启动ioc 容器
@ContextConfiguration("classpath:applicationContext.xml")  // 把配置文件给我
//@ContextConfiguration(classes = SpringConfig.class)  // 把Configuration 修饰的类型 class 引入进来
public class SpringTest {

    @Autowired
    StuService stuService;

    @Test
    public void demo01(){

//        List<Stu> all = stuService.findAll();
//        System.out.println(all);

        //删除
        stuService.deleteStu(1);

    }
}
