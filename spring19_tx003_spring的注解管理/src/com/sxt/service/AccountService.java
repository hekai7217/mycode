package com.sxt.service;

/**
 * @author 黄药师
 * @date 2020-08-17 9:35
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface AccountService {

    // 业务转账
    public void transfer(String outName,String inName,int money);


}
