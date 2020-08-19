package com.sxt.service.impl;

import com.sxt.bean.Stu;
import com.sxt.mapper.StuMapper;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-19 14:53
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *
 */
@Service
public class StuServceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> queryAll() {
        return stuMapper.queryAll();
    }

    @Override
    public int addStu(Stu stu) {
        return stuMapper.addStu(stu);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delStu(Integer id) {

        int row = stuMapper.delStu(id);

        return row > 0 ;
    }
}
