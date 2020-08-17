package com.sxt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 黄药师
 * @date 2020-08-17 9:32
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   和数据库进行交互
 *
 *   事务的管理:
 *   jdbc的事务:
 *
 *    Connection 对象:
 *       事务管理需要使用同一个数据库连接会话 conn
 *
 *       在dao层进行事务管理很麻烦:
 *          1. 从service 传入 connection 进来
 *          2. 用ThreadLocal 保证 统一个线程中 conn 的唯一性
 *
 */
public class AccountDaoImpl {

    // 操作数据库
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *  a转钱给 b
     *  a的钱减少
     */
    public void transferOut(String name,Integer money){

        //数据库的操作
        jdbcTemplate.update("update t_account set money = money - ? where name = ?",
                money,name);
    }

    /**
     *  a转钱给 b
     *  b的钱增加
     */
    public void transferIn(String name,Integer money){

        //数据库的操作
        jdbcTemplate.update("update t_account set money = money + ? where name = ?",
                money,name);

    }



}
