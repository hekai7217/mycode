package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-18 17:15
 * @desc 百"战程序员 http://www.itbaizhan.com
 *   测试返回的数据是  json字符串
 *
 *    1. springmvc 默认和 jackjson 整合 可以返回json字符串
 *
 *    2  需要添加 注解  @ResponseBody 把对象转成json字符串给浏览器回写
 *
 *    @RestController 这个注解 内部就是封装的是:
 *       @Controller +  @ResponseBody
 *
 *   如果你的spring 版本比较高 和  jackjson 有兼容问题
 *
 */
//@Controller
@RestController
public class Demo02Controller {

//    @ResponseBody // 把user对象转成字符串给页面回写
    @RequestMapping("getJson01")
    public User getData(){
        //创建一个对象
        User user = new User();
        user.setUsername("张三");
        user.setEmail("hello");
        user.setPhone("1234");
        user.setPassword("1234");
        return user;
    }

//    @ResponseBody // 把user对象转成字符串给页面回写
    @RequestMapping("getJson02")
    public  List<User> getData02(){

        List<User> users =new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            //创建一个对象
            User user = new User();
            user.setUsername("张三" + i);
            user.setEmail("hello" + i);
            user.setPhone("1234" + i);
            user.setPassword("1234" + i);
            users.add(user);
        }

        return users;
    }

}
