package com.sxt.service.impl;

import com.sxt.service.StuService;
import org.springframework.stereotype.Service;

/**
 * @author 黄药师
 * @date 2020-08-14 10:26
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Service
public class StuServiceAImpl implements StuService {


    @Override
    public void login(){
        System.out.println("StuServiceAImpl.login");
    }
}
