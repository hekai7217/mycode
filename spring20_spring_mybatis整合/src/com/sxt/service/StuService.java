package com.sxt.service;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-17 15:23
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuService {


    List<Stu> findStuAll();

    Stu findStuById(Integer id);

    int deleteStu(Integer id);

}
