package com.sxt.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 黄药师
 * @date 2020-08-14 14:10
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Repository  // dao层注解
public class StuDao {

    public void login(){
        System.out.println("StuDao.login");
    }
}
