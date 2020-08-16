package com.sxt.service.impl;

import com.sxt.service.UserService;
import com.sxt.utils.TrsactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黄药师
 * @date 2020-08-15 9:50
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   业务层 做操作的时候  删除添加
 *   // 会有事务 管理
 *   // 日志管理
 *
 *    1. 方法有大量的重复的代码
 *    2. 给事务的时候 (在代码中进行编码 你修改了原来的代码)
 *
 *   解决方案用aop:
 *        把重复的代码进行抽取,在不用修改原来的代码基础上
 *        代码进行了增强( 可以进行日志 ,事务管理)
     *  1. jdk动态代理
     *  2. cglib 代理
 *
 */
@Service
public class UserServiceImpl implements UserService {

    //注入 ioc容器注入
    @Autowired
    private TrsactionManager tm;

    /**
     *  事务操作:
     *     开启
     *     提交
     *     回滚
     *     关闭session
     */
    @Override
    public void insert() {

        // ctrl + alt + t 添加代码块
        try {
            tm.begin();
            System.out.println("UserServiceImpl.insert");
            tm.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback();
        } finally {
            tm.close();
        }
    }

    @Override
    public void update() {

        try {
            tm.begin();
            System.out.println("UserServiceImpl.update");
            tm.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback();
        } finally {
            tm.close();
        }

    }
}
