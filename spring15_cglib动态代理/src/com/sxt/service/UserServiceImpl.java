package com.sxt.service;

import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-15 11:26
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    cglib 可以 实现 没有 接口实现 可以实现动态代理:
 *
 *    cglib 会通过真实对象, 代理生成一个 真实对象的子类
 *            可以重写真实对象的方法, 可以对这个方法进行 扩展
 *
 *    1. 导入 cglib的 jar
 *           spring 的core 包中 已经集成 了 cglib
 *
 *    2. 写一个service类  这个类没有接口 写方法
 */
@Component
public class UserServiceImpl {

    public void update(){
        System.out.println("UserServiceImpl.update");
    }

    public void insert(){
        System.out.println("UserServiceImpl.insert");
    }
}
