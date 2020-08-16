package com.sxt.demo01.test;

import com.sxt.demo01.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-12 11:12
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    测试容器创建对象的方法
 */
public class Spring02Test {

    @Test
    public void demo01(){

        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取容器中的对象
        Student stu = app.getBean("stu", Student.class);
        System.out.println(stu);

    }

    @Test
    public void demo02(){

        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取容器中的对象
        // 通过静态工厂创建对象
        Bean b = app.getBean("stu1", Bean.class);
        System.out.println(b);

    }

    @Test
    public void demo03(){

        // 创建容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取容器中的对象
        // 实现 接口 FactoryBean 来创建对象
        Bean2 b = app.getBean("stu2", Bean2.class);
        System.out.println(b);
    }

    @Test
    public void demo04(){

        // 创建容器
        AbstractApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取容器中的对象
        //spring启动后 创建对象 调用了init方法
        Person p1 = app.getBean("p1", Person.class);

        // destory 方法 (对象销毁)
        // 没有配置对象的生命周期 (对象的生命周期默认是 单例 (ioc容器关闭后 p对象才会销毁))

        System.out.println(p1);

        // ApplicationContext 接口 他的子类或者实现类有close方法  关闭容器

        // AbstractApplicationContext 这里提供了 close  关闭容器 销毁所有的beans

        app.close();
    }
}
