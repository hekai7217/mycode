package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-21 9:29
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   整合mp操作步骤:
 *
 *    1 添加jar
 *      ssm的jar + mp的jar
 *
 *    2.添加配置文件
 *        spring的配置文件
 *        db.properties 文件
 *        log4j 日志文件
 *        mybatis-config.xml 文件(可以不要)
 *
 *    3. 修改配置文件
 *         数据库配置文件: 修改为指定的数据库
 *         修改spring配置文件
 *         将Mybatis的工厂bean替换为MybatisPlus的工厂bean即可。
 *         <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
 *
 *    4. 书写 bean和数据库表的映射
 *
 *    5.  在mapper层创建StudentMapper 继承 baseMapper( mp 提供的通用的 底层的Mapper 接口)
 *
 *    环境搭建完毕
 *
 *    测试mp
 *      1. 从ioc容器中获取  studentMapper对象
 *
 *     异常01:
 *        Caused by: java.lang.ClassNotFoundException: org.mybatis.logging.LoggerFactory
 *
 *     mybatisplus 和  spring整合的版本问题
 *        mybatis 和 spring 整合包的版本问题
 *
 *      异常02:
 *         Table 'mp.student' doesn't exist   mp这个数据库中没有student这个表
 *             默认 对象的名称和表的名称一致
 *  *          解决 @TableName("t_student") 把对象和 数据库的表进行映射
 *
 */
public class TestMp {

    @Test
    public void helloMp(){

        // 1 拿到 ioc容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 获取mapper
        StudentMapper studentMapper = app.getBean("studentMapper", StudentMapper.class);

        // 内置了一些方法 可以直接调用

        List<Student> students = studentMapper.selectList(null);

        System.out.println("students = " + students);

    }

}
