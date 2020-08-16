package com.sxt.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-14 9:51
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * @copre 注解 和  xml中 bean标签的
 *  @Scope("singleton")
 *  <bean id="xxx" class="xxx" scope="singleton"></bean>
 */
@Component  // 把对象使用注解的方法 放到ioc容器中
@Scope("singleton")  // 配置单列
//@Scope("prototype")  // 多例 配置
public class User {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
