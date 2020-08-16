package com.sxt.demo01.service;

/**
 * @author 黄药师
 * @date 2020-08-12 9:47
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    spring 的入门程序的开发步骤:
 *      1. 创建 Java项目
 *      2. 导入 spring的jar
 *          4个核心jar
 *               context / bean / core / ex  jar
 *          spring 整合 日志包    需要到 导入 logging.jar
 *                common-logging.jar
 *
 *     3. 写一个简单的java 类型
 *
 *     4. 通过spring的xml的配置
 *        把这个Java配置到spring容器中 (spring会自动创建对象 添加到容器中，需要用这个对象 从spring容器中获取 )
 *
 *
 *    5. 从spring容器中获取对象
 *           1. 创建容器
 *           2.  从容器中获取对象 getBean()
 *
 */
public class StuService {

    public void  hello(){
        System.out.println("hello spring ....");
    }

}
