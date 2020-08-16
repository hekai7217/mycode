package com.sxt.test;

import com.sxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-15 9:57
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void service(){

        userService.update();

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");

        userService.insert();
    }

}
