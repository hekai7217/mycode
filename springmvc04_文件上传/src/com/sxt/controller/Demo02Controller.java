package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 黄药师
 * @date 2020-08-19 10:54
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    如果你 :   @RequestMapping("demo01.do")  拦截中 拦截了   不会放行   转发到了  登录页面
 *
 *    如果你     @RequestMapping("login.do") 登录操作   不拦截
 *               再次访问    @RequestMapping("demo01.do") 判断你登录 可以放行
 *
 */
@Controller
public class Demo02Controller {

    /**
     * 处理登录的方法
     * @param name
     * @param session
     * @return
     */
    @RequestMapping("login.do")
    public String login(String name, HttpSession session){
        session.setAttribute("name",name);
        return "/view/success.jsp";
    }

    @RequestMapping("demo01.do")
    public String demo01(){
        return "/view/success.jsp";
    }

}
