package com.sxt.service;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-19 14:53
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuService {

    //查询所有
    public List<Stu> queryAll();

    /**
     * 添加学生
     * @param stu
     * @return
     */
    int addStu(Stu stu);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delStu(Integer id);
}
