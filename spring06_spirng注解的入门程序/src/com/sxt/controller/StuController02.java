package com.sxt.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author 黄药师
 * @date 2020-08-14 9:33
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * 跟@component 注解一样的的功能的注解有四个
 * @controller
 * @service
 * @Repository
 *     这个三个注解用于分层
 *       在springmvc中   控制层必须用 controller
 *       其他情况可以随便使用(开发的原则  分层使用欧冠正确的注解 不要随便瞎用 )
 */
@Service("stuCon02")
public class StuController02 {
    public void save(){
        System.out.println("StuController.save");
    }
}
