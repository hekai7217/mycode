package com.sxt.test;

import com.sxt.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-14 15:23
 * @desc 百战程序员 http://www.itbaizhan.com
 *    junit和 spring的整合
 *     1. 导入 spring-test.jar
 *     2. 创建类 注入到 ioc容器中
 *     3. 启动ioc容器
 *          @RunWith  启动ioc容器
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 启动ioc 容器
@ContextConfiguration("classpath:applicationContext.xml")  // 把配置文件给我
//@ContextConfiguration(classes = SpringConfig.class)  // 把Configuration 修饰的类型 class 引入进来
public class SpringTest {

    //用了  RunWith 和   ContextConfiguration  测试环境中有ioc容器
    // 现在需要测试 直接给  注入
    @Autowired
    StuService stuService;

    @Test
    public void demo01(){
        stuService.login();
    }
}
