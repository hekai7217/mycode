package com.sxt.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄药师
 * @date 2020-08-18 9:23
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   mvc的入门程序:
 *
 *   1. 导入jar
 *       spring 的核心包  4
 *       日志 包
 *       mvc的包
 *          spring-web.jar
 *          spring-webmvc.jar
 *
 *         web项目的jar 需要放到 WEB-INF下面的lib中?
 *              1. tomcat会默认取 找class文件 (找java代码编译后的位置 )
 *                       tomcat 设置了2 个路径: WEB-INF/classes / WEB-INF/lib/
 *
 *   2. 写 controller(开发者自己完成)
 *         处理器: 有多种开发方式
 *             1. 实现接口Controller
 *             2. 可以用注解开发 (推荐)
 *
 *          handleRequest 处理请求
 *          ModelAndView  模型视图
 *          给数据/给视图  (把数据转发到 页面)
 *
 *   3. 配置映射 ?
 *     在 springmvc.xml 配置文件中进行 配置映射
 *     <bean name="/hello" class="com.sxt.controller.HelloController"></bean>
 *
 *   4. 启动容器
 *        配置 前端控制器
 *        1. 在web.xml中配置 前端控制器
 *        2. 在控制器中配置 ioc容器的启动
 *
 */
public class HelloController implements Controller {


    // 和 servlet中的doget 处理一样的
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // 创建mv
        ModelAndView mv = new ModelAndView();

        // 添加数据   模型添加数据
//        req.setAttribute();
        mv.addObject("name","黄蓉");

        // 给页面
        mv.setViewName("demo01.jsp");

        return mv;
    }
}
