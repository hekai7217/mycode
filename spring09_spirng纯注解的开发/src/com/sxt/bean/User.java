package com.sxt.bean;

/**
 * @author 黄药师
 * @date 2020-08-14 14:35
 * @desc 百战程序员 http://www.itbaizhan.com
 */
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
