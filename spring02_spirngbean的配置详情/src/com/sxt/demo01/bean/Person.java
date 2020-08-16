package com.sxt.demo01.bean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:22
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Person {

    // 创建对象的时候会 调用
    public void init(){ // DataSource 初始化操作
        System.out.println("Person.init");
    }

    // 对象销毁的时候会调用
    public void destroy(){  // DataSource 关闭需要把资源清理
        System.out.println("Person.destroy");
    }
}
