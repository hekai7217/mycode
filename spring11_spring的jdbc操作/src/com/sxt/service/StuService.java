package com.sxt.service;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-14 10:26
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuService {

   List<Stu> findAll();
   void  insetStu(Stu s);
   void updateStu(Stu stu);
   void deleteStu(Integer id);
}
