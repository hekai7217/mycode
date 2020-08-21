package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-08-21 10:22
 * @desc 百战程序员 http://www.itbaizhan.com
 * 测试 crud
 */

public class TestMp03 {


    @Test
    public void delete01(){

        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        StudentMapper studentMapper = app.getBean("studentMapper", StudentMapper.class);

        // studentMapper是 动态mapper代理对象

        //  这个动态代理对象 里面  sqlSession (操作 拿到mapper代理)

        // sqlSession 这里有一个 sqlSessionFactroy  里面有 Configuration
        //      Configuration 这里有  MappedStatement(执行具体的方法(sql))
        //                         jdbc操作 PrepreStatement
        // Configuration 有很多 MappedStatement (一个方法一个MappedStatement)

        // MappedStatement 有  key(方法的名称) - vlaue (SqlSource 这有sql)

        // MappedStatement 可以把方法和sql 进行绑定 进行执行 指定操作 (curd)


        //通过id删除
        int i = studentMapper.deleteById(13);
        System.out.println(i);
    }
}
