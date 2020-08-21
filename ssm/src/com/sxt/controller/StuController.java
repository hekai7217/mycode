package com.sxt.controller;

import com.sxt.bean.Result;
import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @author 黄药师
 * @date 2020-08-19 14:38
 * @desc 百战程序员 http://www.itbaizhan.com
 *   ssm整合:
 *     1 导入jar
 *          spring的jar
 *            4 个核心  1个 日志
 *          aop的jar  3 个jar
 *
 *          事务:  jdbc/tx  2个jar
 *
 *           mybatis 的jar  3
 *                核心jar  mybatis-3.5.2.jar
 *                mybatis-spring 整合jar
 *                日志  log4j
 *           数据库的jar    2
 *                数据库连接池  1
 *                数据库驱动    1
 *
 *            jsp  2个
 *     2.添加及配置文件
 *         application.xml  ioc容器  (处理依赖关系和创建对象 )
 *         db.properties  数据文件
 *         log4j.properties 日志
 *         mybatis-config.xml
 *         springmvc.xml  (处理控制层的一些配置 )
 *
 *     3. mapper /service / controller 的依赖关系
 *        1. 分包
 *        2  写mapper
 *        3  写 service
 *        4  写controller
 *
 *     4. 修改配置文件
 *
 *     5. 启动容器 (web.xml) 文件的配置
 *        在web.xml中配置
 *            application.xml
 *            springmvc.xml
 */
@Controller
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("/queryAll.do")
    public String queryAll(Model m){

        // 查询   调用业务
        List<Stu> stus = stuService.queryAll();
        m.addAttribute("stus",stus);
        return "stus";
    }

    /**
     *   跳转到 添加页面
     * @return
     */
    @RequestMapping("/toAddStu.do")
    public String toAddStu(){
        //页面跳转
        return "addStu";
    }

    /**
     *   直接把数据封装到 对象中  进行绑定
     * @return
     */
    @RequestMapping("/addStu.do")
    public String addStu(Stu stu){
        //业务 addStu
        int i = stuService.addStu(stu);
        return "redirect:/queryAll.do";
    }

    /**
     *  转成 json对象
     *    需要导报 + 注解
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("delstu.do")
    public Result delStu(Integer id){
        //业务delStu

       boolean del= stuService.delStu(id);

       return new Result(del, del ? "删除成功":"删除失败");
    }

}
