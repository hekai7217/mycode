package com.sxt.demo01.test;

import com.sxt.demo01.service.CusumerService;
import com.sxt.demo01.service.impl.CusumerServiceImpl01;
import com.sxt.demo01.service.impl.CusumerServiceImpl02;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-12 10:54
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Demo02SpringTest {


    @Test
    public void demo01(){

        // 传统方式  代码业务的变动
        CusumerService service = new CusumerServiceImpl01();
        service.save();

        // 代码变动很大
        CusumerService service2 = new CusumerServiceImpl02();
        service2.save();

    }


    @Test
    public void demo02(){

        //spring的方式

        //获取容器
        // application文件 写到 位置是src 下面
        // application文件 名称可以随便取 (读文件不要写错了)
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从ioc获取对象

        //ioc 操作后  可以不用再在 修改代码的基础上
        // 实现程序功能的变化 (只需要修改xml的配置就可以 )
        CusumerService cService1 = app.getBean("cService1", CusumerService.class);
        cService1.save();

    }

}
