package com.sxt.bean;

import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-08-21 15:56
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class TestUser {

    @Test
    public void testUser(){

        User u = new User();
        u.setName("赵敏");
        u.setAge(25);
        System.out.println("u = " + u);

    }

}
