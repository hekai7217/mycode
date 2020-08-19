package com.sxt.mapper;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-19 14:51
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuMapper {

    List<Stu> queryAll();

    /*
      添加学生
     */
    int addStu(Stu stu);

    /**
     * 删除
     * @param id
     * @return
     */
    int delStu(Integer id);
}
