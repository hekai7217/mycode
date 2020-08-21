package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-21 14:25
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  mp分页的实现:
 *
 *    1 . 需要配置 发分页的插件
 *
 *        在sqlSessionFactory 中配置分页插件
 *         <property name="plugins">
 *             <array>
 *                 <bean class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor">
 *                     <property name="dbType" value="MYSQL"></property>
 *                 </bean>
 *             </array>
 *         </property>
 *
 *    2. 分页的代码实现
 *      调用 selectPage的方法
 *         selectPage(page,条件)
 *      注意： 需要导入    jsqlparser-3.1.jar 分页的解析器
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp05 {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectPage(){

        // 分页的方法都是selectPage开头

        // Page 分页的数据的封装
        // 参数1  当前的页面  current = 1
        // 参数2  每页显示的数据  pageSize = 2
        Page<Student> p = new Page<Student>(2,2);

        Page<Student> page = studentMapper.selectPage(p, null);
        //分页的数据封装在 page 中
        System.out.println("总数：" + page.getTotal());
        System.out.println("当前的页面：" + page.getCurrent());
        System.out.println("分页的数据：" + page.getRecords());

    }

    @Test
    public void selectPage02(){

        //条件查询的分页
        Page<Student> p = new Page<Student>(1,2);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("s_name","黄");

        // sql 的拼接: 自动拼接 where 条件   litmit分页
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE (s_name LIKE ?) LIMIT ?,?

        Page<Student> page = studentMapper.selectPage(p, queryWrapper);
        //分页的数据封装在 page 中
        System.out.println("总数：" + page.getTotal());
        System.out.println("当前的页面：" + page.getCurrent());
        System.out.println("分页的数据：" + page.getRecords());

    }
}
