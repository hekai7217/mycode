package com.sxt.demo01.controller;

import com.sxt.demo01.service.Userservice;

/**
 * @author 黄药师
 * @date 2020-08-12 16:24
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class UserServlet {

    private Userservice userservice;

    public void setUserservice(Userservice userservice) {
        this.userservice = userservice;
    }

    // 处理请求的操作
    public void service(){

        // 注册
        userservice.register("张三","123");

    }
}
