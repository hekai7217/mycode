package com.sxt.controller;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-08-15 9:13
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   spring 和 javaweb的整合
 *
 *   1. 导入核心jar
 *       4 个核心
 *       1 日志
 *       spring-web.jar
 *
 *   2. 写servlet / controller   把service 配置到ioc容器中
 *
 *   3. 启动ioc容器
 *        在 web.xml配置监听器
 *
 *   4. controller中的 业务层从ioc容器中获取
 *      ioc的容器怎么获取
 *           spring-web.jar 提供了工具类 获取ioc容器
 *
 *   5. 访问 servlet的 测试
 *
 */
@WebServlet("/stu")
public class StuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ioc容器的获取 需要参数 servletContext
       ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

       //从 ioc容器中获取
       StuService stuService = app.getBean("stuService", StuService.class);

       //业务
        Stu stu = stuService.findStuById(1);
        req.setAttribute("stu",stu);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
