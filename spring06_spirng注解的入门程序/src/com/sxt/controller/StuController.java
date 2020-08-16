package com.sxt.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-14 9:33
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  把 StuController 对象通过注解注入到 ioc容器中
 *
 *   Component 注解是 组件
 *      可以直接用在类上面  spring 会扫描这个注解 发现了这个创建对象
 *      把对象放到容器中管理
 *
 *      这个注解有value 属性 可以 给value赋值
 *        value的赋值 就是 容器中 bean的  id/name
 *      如果不给value 属性  默认的id 类的首字符小写   默认id=stuController
 *
 */
@Component("stuCon")
public class StuController {
    public void save(){
        System.out.println("StuController.save");
    }

}
