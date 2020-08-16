package com.sxt.demo01.bean;

import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-08-12 11:07
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   di的注入:
 *    1. set 的注入
 *       bean对象必须有set方法
 */
public class User {

    private String name;

    private String age;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // user中有car的引用
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

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

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public java.lang.String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
