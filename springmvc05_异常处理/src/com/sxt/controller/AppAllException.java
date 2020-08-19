package com.sxt.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 黄药师
 * @date 2020-08-19 14:14
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   全局的异常处理
 *   作用域：全局，针对全部Controller中的指定异常类；
 *   ControllerAdvice 该注解需要 和@ExceptionHandler配合，来完成全局异常的处理；
 *
 *   这个异常处理:
 *
 *   整个web项目出现了 异常  ArithmeticException 会执行  exception01 处理方法
 *
 */
//@ControllerAdvice
public class AppAllException {


    //处理异常的方法
//    @ExceptionHandler(ArithmeticException.class)
//    public String exception01(ArithmeticException e, Model m){
//
//        m.addAttribute("msg",e.getMessage());
//
//        return "/view/message.jsp";
//    }

    //处理异常的方法
//    @ExceptionHandler(NullPointerException.class)
//    public String exception02(ArithmeticException e){
//
//        return "/view/message.jsp";
//    }
}
