package com.sxt.controller;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-08-14 16:13
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    spring和 javaWeb项目的整合
 *     1. 创建javaweb项目
 *     2. 导入jar
 *            spring 核心  4
 *            有jdbc操作 jdbc / tx
 *            数据库连接池 / 数据库的驱动
 *            logging 日志包
 *
 *            和web项目整合 需要添加spring-web.jar
 *
 *    3.添加spring 配置文件
 *    4. 正常的写  service 配置到 ioc容器中
 *    5. 启动容器
 *          需要在web.xml中进行配置
 *
 *    6. 拿到ioc容器
 *       servletContext可以获取容器
 *      拿到service 进行操作
 *
 */
@WebServlet("/stu")
public class StuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取容器  在java项目是 这样获取
//        ApplicationContext app = new ClassPathXmlApplicationContext()

        // javaWeb项目时候 spring-web.jar 提供工具类获取ioc容器
        ServletContext servletContext = getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        // 获取 service
        StuService stuService = webApplicationContext.getBean("stuService", StuService.class);

        Stu stu = stuService.findStuById(1);

        req.setAttribute("stu",stu);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
