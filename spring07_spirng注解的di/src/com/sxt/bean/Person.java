package com.sxt.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-14 11:07
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * @Value 注解
 *     01 只能注入 基本的数据了下 和包装类型
 *             @Value("王语嫣")
 *     02 可以注入 properties 文件的数据
 *            @Value("${可以获取proper文件中的数据}")
 *            pro文件中的key 获取值 注入到 属性中
 *            @Value("${p.name}")
 *            @Value("${p.age}")
 */
@Component  // 把user 放到ioc容器中
public class Person {

    @Value("${p.name}")
    private String name;

    @Value("${p.age}")
    private String age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
