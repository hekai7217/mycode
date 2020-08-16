package com.sxt.utils;

import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-15 9:52
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Component
public class TrsactionManager  {

    public void begin(){
        System.out.println("开始事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }

    public void rollback(){
        System.out.println("回滚事务");
    }

    public void close(){
        System.out.println("关闭session");
    }
}
