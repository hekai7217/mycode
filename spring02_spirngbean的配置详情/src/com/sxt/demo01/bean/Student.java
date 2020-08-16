package com.sxt.demo01.bean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:06
 * @desc 百战程序员 http://www.itbaizhan.com
 *    stu 配置在spirng中 创建对象调用的是空构造( 用的最多)
 */
public class Student {

    private String name;

    private Integer age;

    public Student() {

        // 提前操作

        System.out.println("Student.Student");
    }
}
