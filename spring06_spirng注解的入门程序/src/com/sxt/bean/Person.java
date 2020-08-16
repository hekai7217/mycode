package com.sxt.bean;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 黄药师
 * @date 2020-08-14 10:16
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * @PostConstruct   init-method=""
 * @PreDestroy      destory-method=""
 *   2个注解 和bean 标签 中的
 *   <bean id="xxx" class="xxx" init-method="" destory-method=""></bean>
 *
 *
 */
@Component
public class Person {

    @PostConstruct  // 对象初始化的方法
    public void init(){
        System.out.println("Person.init");
    }

    @PreDestroy   // 对象的销毁 方法
    public void destory(){
        System.out.println("Person.destory");
    }
}
