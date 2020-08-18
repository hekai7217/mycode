package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.java2d.pipe.SpanIterator;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄药师
 * @date 2020-08-18 14:14
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   测试 页面传递过来的数据:
 *
 *     数据绑定: 页面传递过来的数据   直接和处理请求方法上面的数据进行绑定
 *
 *    01  mvc 提供了 可以直接在方法上 注入 javaweb的组件
 *       HttpServletRequest
 *       HttpServletRespone
 *       HttpSession
  *     用法和servlet中一样
 *
 *    02 mvc框架 会直接解析 表单提交过来的数据  封装到 处理方法的参数进行绑定
 *
 *
 */
@Controller
public class Demo01Controller {

    @RequestMapping("data01")
    public void data01(HttpServletRequest req){

        String name = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(name);
        System.out.println(age);

    }

    /**
     *   mvc会解析 表单提交的数据 直接和方法参数进行绑定
     * @param username
     * @param age
     */
    @RequestMapping("data02")
    public void data02(String username,String age){

        System.out.println(username);
        System.out.println(age);

    }

    /**
     *  如果前端 和 处理请求方法 参数不一致  可以使用@RequestParams 来解决
     *
     *  @RequestParam("username") 从表单提交的数据中 获取key为username
     *  的值, 把这个值复制给  name变量
     * @param name
     * @param uage
     */
    @RequestMapping("data03")
    public void data03(@RequestParam("username") String name,@RequestParam("age") String uage){

        System.out.println(name);
        System.out.println(uage);

    }

    /**
     *   mvc 可以 直接 获取 页面提交过来的数组 和参数进行绑定
     * @param hobbys
     */
    @RequestMapping("data04")
    public void data04(String [] hobbys){
        System.out.println(Arrays.toString(hobbys));
    }


    /**
     *   mvc 可以直接把 表单提交的数据封装到一个javabean 和参数进行绑定
     *
     *   1. 页面的表单提交数据的name的值和 javabean对象的 属性名称要一致
     *
     *   Map<> map = </> req.getParXX()
     *   反射把map 转成 Javabean对象
     *
     * @param user
     */
    @RequestMapping("data05")
    public void data05(User user){
        System.out.println(user);
    }

    /**
     *  mvc 可以直接把 表单的数据 封装到 一个map中 和处理请求的方法进行绑定
     *
     *  需要用注解进 绑定 @RequestParam
     *
     *   如果是 提交的是数组 只能获取一个数值 (map中的key唯一 )
     *
     * @param map
     */
    @RequestMapping("data06")
    public void data06(@RequestParam Map<String,Object> map){

        // map的 拿到 entrySet
        // 遍历 set
        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + " === >" + entry.getValue());
        }
    }

}
