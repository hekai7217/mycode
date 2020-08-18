package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄药师
 * @date 2020-08-18 14:14
 * @desc 百战程序员 http://www.itbaizhan.com
 * <p>
 * 测试 自定的参数绑定  日期类型
 * <p>
 * 小结:
 * 1 页面提交过来的 yyyy-MM-dd 的数据格式可以直接用 字符串接受
 * <p>
 * 2 自己写转换器 把字符串转成date数据
 * 1. 实现 spring的转换接口
 * 2. 装换接口需要在mvc中进行配置
 * <p>
 * 3, 使用  @DateTimeFormat 用在类的属性/ 方法的参数上 可以直接把对应的字符串转成
 * Date类型
 */
@Controller
public class Demo02Controller {

    /**
     * 提交过来的的是 字符串
     * yyyy-MM-dd
     *
     * @param birth
     */
    @RequestMapping("/date01")
    public void date01(String birth) {
        System.out.println(birth);
    }

    /**
     * 提交过来的的是 字符串
     * yyyy-MM-dd
     * 不能直接转成date
     * <p>
     * beanUtils中如何处理?
     * 转换器
     * mvc 提供了转换器
     * <p>
     * 更加简洁的方法 :
     * <p>
     * DateTimeFormat(pattern = "yyyy-MM-dd")  这个注解可以直接用在方法参数上
     * 把  "yyyy-MM-dd" 格式的字符串直接转成 date 类型 赋值 给  birth
     * 1. 用到 属性上面和 方法参数上面
     * 2. 一定要注意数据格式
     * 3. @DateTimeFormat(pattern = "yyyy-MM-dd") 和 LocalDate 不兼容
     *
     * @param birth
     */
    @RequestMapping("/date02")
    public void date02(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birth) {
        System.out.println(birth);
    }

    // mvc 对restful 风格的参数的获取

    /**
     * {pid} 类似占位符 ?  restful 中传入的参数 pid
     *
     * @param pid
     * @PathVariable("pid") 把路径种的参数获取出来
     * 把这个值赋值 给变量  pid
     */
    @RequestMapping("/rest/{pid}")
    public void date03(@PathVariable("pid") Integer pid) {
        System.out.println(pid);
    }

    @RequestMapping("/code")
    public void code(String name,String info){

//        URLDecoder  url编码 处理 网络中的特殊字符串
        // tomcat 会自动解析 识别这个编码

        System.out.println(name);
        System.out.println(info);
    }
}
