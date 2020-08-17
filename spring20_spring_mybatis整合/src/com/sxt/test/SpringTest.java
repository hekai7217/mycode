package com.sxt.test;

import com.sxt.bean.Stu;
import com.sxt.dao.StuMapper;
import com.sxt.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-17 15:04
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   spring 和mybatis 进行整合 :
 *
 *    1 导入jar
     *       1. spring的jar
     *          4个核心包
     *          3个aop包
     *          2个事务包  jdbc/tx 包
     *          日志包 commons.logging
     *       2.mybatis的jar
     *           mybatis.jar
     *           mysql驱动.jar
     *           log4j.jar
     *       3. 数据库连接jar
     *           driud 连接池的包
     *       4. mybatis-spring 整合的jar
 *
 *    2.需要配置文件
 *       spring.xml
 *       mybatis的配置文件
 *           mybatis-config.xml
 *           db.properties.xml 数据连接文件
 *           log4j的配置文件
 *
 *    3. 通过spring创建了 sqlSessionFactory
 *
 *    4. sqlSessionFactory拿到session 通过session拿到 mapper对象
 *              session.getMapper(Mapper.class);
 *          交给spring来创建:
 *          MapperFactoryBean 创建一个mapper
 *
 *   5. 从ioc容器中获取mapper
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private StuService stuService;

    @Test
    public void demo01(){
        List<Stu> stuAll = stuService.findStuAll();
        System.out.println(stuAll);

//        System.out.println(stuService.findStuById(3));

    }
}

