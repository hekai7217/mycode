package com.sxt.controller;

import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author 黄药师
 * @date 2020-08-14 10:27
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *      注解注入的方案2:
 *      @Resource   java sun提供个解决方案
 *                     @Resource = @autowride + Qualifier
 *
 *      @Resource可以使用 name 注入指定的id
 *      @Resource 不能用在构造方法上面
 *
 *        @Resource(name = "serviceA") 注入指定的id 对象
 */
@Controller
public class StuController01 {

    // 在ioc容器中找  StuService 的id是 serviceA 把他注入进来
//    @Resource(name = "serviceA")
//    private StuService stuService;

    //  @Resource  优先 用   name = "serviceA" 找
    //  没有name的话用  类型去找  StuService
    //  如果按照类型去找 有多个类型 会报错

    @Resource
    private StuService stuService;

    public void save(){
        System.out.println("StuController.save");
        stuService.save();
    }

}
