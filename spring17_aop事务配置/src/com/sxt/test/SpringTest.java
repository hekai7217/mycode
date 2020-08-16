package com.sxt.test;

import com.sxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-15 9:57
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    基于springxml的aop的开发:
 *
 *    1.  导入包
 *       4个核心
 *       1 日志
 *       导入aop的需要用到的包
 *          2 个
 *          aop
 *          apsect
 *       第三方的aop联盟包
 *
 *   2. 写一个 service 类型  ( 使用aop 给service中的方法 加强  )
 *
 *   3. aop的配置
 *     <aop:config>
 *
// *        切点
            切面( 通知 + 切点)
 *
 *     </aop:config>
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    ApplicationContext app;

    @Test
    public void aaa(){
        UserService userService = app.getBean("userService", UserService.class);
        userService.update();
    }

}
