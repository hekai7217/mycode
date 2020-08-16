package com.sxt.controller;

import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 黄药师
 * @date 2020-08-14 14:11
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Controller
public class StuController {

        // 需要依赖 service
    @Autowired
    private StuService stuService;

    public void login(){
        stuService.login();
    }

}
