package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author 黄药师
 * @date 2020-08-19 9:30
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  测试异常处理
 *    4.4.@ExceptionHandler 注解  只能处理单个 controller 的异常
 */
@Controller
public class Demo01Controller {

    @RequestMapping("/deme01.do")
    public String demo01(){

        // 有异常   自己处理   不会到 前端控制器进行处理
//        try {
//            int a = 10 / 0 ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int a = 10 / 0 ; // 给 前端控制了
        return "/view/success.jsp";
    }

    // 处理异常的方法
    // @ExceptionHandler 参数为 要处理器的 异常类(或子类)
    @ExceptionHandler(ArithmeticException.class)
    public String excetionMethod(ArithmeticException e){
        System.out.println(e.getMessage());
        System.out.println("处理异常...");
        return "/view/message.jsp";
    }

}
