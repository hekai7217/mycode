package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-08-18 15:54
 * @desc 百战程序员 http://www.itbaizhan.com
 *     1, mvc 的响应操作
 *        1. 返回的是void 数据和页面的条件
 *
 *           处理请求的方法中: 注入javaWeb的httpServletRequest 组件
 *              数据共享/ 页面跳转
 *
 *       2. modelAndView    模型和视图
 *            数据的添加
 *                       mv.addObject() 添加数据
 *            视图的设置
 *                      mv.setViewName();
 *
 *       3 返回的是字符串
 *
 *          直接返回字符串
 *
 *     请求处理发送数据点到 页面:
 *
 *       1. void  + javaweb的组件
 *
 *       2. ModelAndView   视图 / 数据都在m中
 *
 *       3 String + Model / ModelMap 发送数据到页面
 *
 *
 */
@Controller
public class Demo01Controller {

    // 处理请求的方法
    @RequestMapping("resp01")
     public void resp01(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         // 设置数据
         req.setAttribute("name","东方不败");

         // 转发操作
         // 服务器内部操作   /资源
         req.getRequestDispatcher("/resp/demo01.jsp").forward(req,resp);
     }

    // 处理请求的方法
    @RequestMapping("resp02")
    public ModelAndView resp02() throws ServletException, IOException {

        // 和 req的操作一样
        //  设置数据  页面的跳转
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("name","郭靖");

        // 视图从名称
        // 路径问题
//        mv.setViewName("/resp/demo02.jsp");
        // 配置了视图解析器后
        // 不用谢前缀 和 后缀 可以直接写 视图的名称
        //  视图解析器的前缀 + demo01 + 视图解析器的后缀
        mv.setViewName("demo01");

        return mv;
    }

    /**
     * 可以直接返回字符串
     *    返回的字符串可以直接给视图名称
     *
     *   如果直接返回 视图名称
     *      数据没有传递
     *
     *      mvc的框架提供了一个Model  这个接口 可以传递数据
     *       把数据发送到页面
     *
     *      可以直接在方法上用model 注入进来
     *      ModelMap 也可以把数据发送到页面
     *
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("resp03")
    public String resp03(ModelMap map) throws ServletException, IOException {
        // 可以直接给视图的名称
//        m.addAttribute("name","乔峰");
        map.addAttribute("name","王语嫣");

        return "demo02";
    }

    /**
     *  如果需要 自定义转发  和重定向 应该怎么操作
     *
     *  如果你用了:
     *   自定义的重定向 / 转发
     *   视图解析会判断处理 前缀 后缀配置失效
     *
     *   你的转发 写正常的路径
     *
     *   转发:  forward:xxx 路径   只能内部转发
     *         /xxx资源
     *
     *   重定向: redirect:xxx 路径
     *        自己带了一个项目的访问路径  不要加 项目的访问路径
     *          /xxx/xxx资源
     *
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("resp04")
    public String resp04() throws ServletException, IOException {
        // 转发
        return "forward:/resp/demo03.jsp";
    }

    @RequestMapping("resp05")
    public String resp05() throws ServletException, IOException {
        // 重定向
//        return "redirect:http://www.bz6000.cn";
        // 重定向 demo03.jsp
        //  和javaweb 项目不一样  自己加了 项目的访问目录
        return "redirect:/resp/demo03.jsp";
    }

    // 默认取 解析的配置中找打  我们默认的请求url的视图
    // 默认取 /resp/ 下面找 resp06.jsp文件
    @RequestMapping("resp06")
    @ModelAttribute("key")  // 可以设置 model在 jsp页面用指定的el表达式获取  传入的属性值
    public User resp06() {
        User user = new User();

        user.setUsername("尹志平");
        user.setPhone("123");
        user.setEmail("123@qq.com");
        return user;
    }
}

