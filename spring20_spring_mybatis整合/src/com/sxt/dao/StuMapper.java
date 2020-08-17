package com.sxt.dao;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-17 15:17
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuMapper {

    /**
     * 查询
     * @param id
     * @return
     */
    Stu findStuById(Integer id);

    /**
     * 查询所有
     * @param id
     * @return
     */
    List<Stu> findStuAll();

    /**
     *  删除
     * @param id
     * @return
     */
    int deleteStu(Integer id);

}
