package com.sxt.service.impl;

import com.sxt.dao.StuDao;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黄药师
 * @date 2020-08-14 10:26
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Service
public class StuServiceAImpl implements StuService {

    // 需要依赖 dao
    // 注入dap
    @Autowired
    private StuDao stuDao;

    @Override
    public void login() {
        stuDao.login();
    }
}
