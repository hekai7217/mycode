package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author 黄药师
 * @date 2020-08-18 11:18
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * 请求注解 @requestMapper 注解
 *
 *   requestMapper注解的总结:
 *     1 把请求和方法进行绑定的注解 通过url 可以找到指定的方法
 *
 *     2. @requestMapper 可以用在类上面 / 方法上面
 *
 *     3. 属性
 *         value 写映射的url
 *         method  处理请求的方法
 *         params 可以对参数的绑定
 *
 */
@Controller
//@RequestMapping("/user")
public class Demo03Controller {

    /**
     *   RequestMapping 注解:
     *   把请求的url和 处理的方法进行 关联
     *   value  配置url
     *       1. 前端控制的后缀.do 等 可以省略
     *       2. url的斜杠可以 省略
     *       3. RequestMapping可以用在类上面  方法方法的时候
     *         /user/action01  才可以处理的方法
     *
     *   method的使用
     *       可以限定请求的方法:
     *       默认get/post都可以
     *
     *    如果这个写 method = {RequestMethod.GET}只能处理get请求
     */
//    RequestMappingHandlerAdapter
    @RequestMapping(value = "action01",method = {RequestMethod.GET})
    public void req01(){
        System.out.println("Demo03Controller.req01");
    }

    /*   method的使用
     *       可以限定请求的方法:
     *       默认get/post都可以
     *
     *    如果这个写 method = {RequestMethod.GET}只能处理get请求 405 不支持 post请求
     *       @GetMapping   只能处理 get请求
             @PostMapping  只能处理Post请求
     */
    @RequestMapping(value = "action02")
    public void req02(){
        System.out.println("Demo03Controller.req02");
    }

    /**
     * params 提交参数的字段的限定
     * params= {"username","password"} 参数必须包含这个字段
     * params= {!"username"} 参数必须包含不能有这个字段
     */
//    @RequestMapping(value = "action03",params = {"!username","password"})
    @RequestMapping(value = "action03",params = {"!username"})
    public void req03(){
        System.out.println("Demo03Controller.req03");
    }
}
