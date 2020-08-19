package com.sxt.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄药师
 * @date 2020-08-19 14:21
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Component
public class AppAllException02 implements HandlerExceptionResolver {

    /**
     *  这里处理全局异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
        // 处理异常

        if (e instanceof ArithmeticException){

            //处理异常
            mv.addObject("msg",e.getMessage());
            mv.setViewName("/view/message.jsp");

        }

        if (e instanceof NullPointerException){
            //处理异常
            mv.addObject("msg","应用执行为null");
            mv.setViewName("/view/message.jsp");
        }

        if (e instanceof MyExcetion){
            MyExcetion my = (MyExcetion) e;
            //处理异常
            System.out.println(my.getMessage());
            mv.addObject("msg",my.getMsg());
            mv.setViewName("/view/message.jsp");
        }

        return mv;
    }
}
