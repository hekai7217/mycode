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
 *
 */
@Component  // 把user 放到ioc容器中
public class User {

    @Value("王语嫣")
    private String name;

    @Value("40")
    private String age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
