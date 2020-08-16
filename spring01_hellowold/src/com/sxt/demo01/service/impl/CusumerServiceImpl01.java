package com.sxt.demo01.service.impl;

import com.sxt.demo01.service.CusumerService;

/**
 * @author 黄药师
 * @date 2020-08-12 10:51
 * @desc 百战程序员 http://www.itbaizhan.com
 *    把service 配置到  ioc容器中
 */
public class CusumerServiceImpl01 implements CusumerService {
    @Override
    public void save() {
        System.out.println("数据添加了 ...");
        System.out.println("CusumerServiceImpl01.save");
    }
}
