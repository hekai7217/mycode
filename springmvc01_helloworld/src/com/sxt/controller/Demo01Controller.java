package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 黄药师
 * @date 2020-08-18 9:50
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    注解开发:
 *      可以在controller的代码上 用@Controller 进行标记
 *          告诉 ioc容器 这个是controller 处理请求
 *
 *      1. 在类上面加注解  在方法上面加注解
 *
 *      2. Demo01Controller 要在 ioc容器创建对象
 *          注解 + 扫描
 *
 */
@Controller
public class Demo01Controller {

    // 写处理请求的方法
    // 处理请求的方法 如何 和 访问的url进行关联?
    // 解决方案 RequestMapping 请求映射 注解  通过url请求找到指定的处理请求的方法
    //
    @RequestMapping("/demo01")
    public ModelAndView handlerRequest(){

        // 创建mv
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","华筝");
        mv.setViewName("demo01.jsp");
        return mv;

    }

}


