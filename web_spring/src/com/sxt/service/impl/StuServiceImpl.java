package com.sxt.service.impl;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;

/**
 * @author 黄药师
 * @date 2020-08-14 16:20
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class StuServiceImpl implements StuService {
    @Override
    public Stu findStuById(Integer id) {

        Stu stu = new Stu();

        stu.setId(1);
        stu.setName("张三");
        stu.setAge(40);

        return stu;
    }
}
