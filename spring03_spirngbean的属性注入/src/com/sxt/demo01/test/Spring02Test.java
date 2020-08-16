package com.sxt.demo01.test;

import com.sxt.demo01.bean.CollectionBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-12 15:26
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   获取集合数据的配置
 */
public class Spring02Test {

    @Test
    public void demo01(){

        // 获取容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取对象
        // 获取set
        CollectionBean coll = app.getBean("collection", CollectionBean.class);
        System.out.println(coll.getSet());
    }

    @Test
    public void demo02(){

        // 获取容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        // 获取 list
        CollectionBean coll = app.getBean("collection", CollectionBean.class);
//        List<String> list = coll.getList();
//
//        list.forEach(System.out::println);

        // 获取map的注入
//        System.out.println(coll.getMap());

        // 获取 properties配置也可以
        System.out.println(coll.getProps());

        // 获取配置的List<Bean对象>

        System.out.println(coll.getCars());
    }

}
