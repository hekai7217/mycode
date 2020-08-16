package com.sxt.demo01.test;

import com.sxt.demo01.service.StuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄药师
 * @date 2020-08-12 9:58
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  ApplicationContext 容器接口
 *     容器有2个具体的实现类:
 *       ClassPathXmlApplicationContext   可以直接读取src下面的xml创建spring容器
 *       FileSystemXmlApplicationContext  通过绝对路径读取xml (用的少 )
 *
 *  spring容器
 *     ApplicationContext 容器接口 继承   BeanFactory 接口
 *
 *     beanFactory
 *         包含了各种Bean的定义，读取bean配置文档，管理bean的加载、实例化，控制bean的生命周期，维护bean之间的依赖关系。
 *
 *         使用这个bean才会价值 bean (延时加载bean )
 *    ApplicationContext  添加了 除了  beanFactory 之前的额外功能
 *         容器启动后就价值bean
 *
 *    一般用 ApplicationContext 比较多?
 *       1. ApplicationContext启动的是 直接创建bean对象 ， 可以检查 bean的配置
 *           beanFactory 使用对象从时候创建bean 可能会出错
 *
 *      2.      beanFactory 手动注册配置   ApplicationContext自动配置
 *
 *      3. ApplicationContext 内存占用大一些
 *
 */
public class HelloTest {

    @Test
    public void hello(){

        // 创建spring容器
        // ClassPathXmlApplicationContext 通过xml创建容器
        // 参数是 xml配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 拿到 bean对象 (spring 容器中获取 )
        // 参数1 xml 配置的id  xml中的class
        
        // 以前都是 自己new 对象 
        // 把对象配置到 spring容器中   spring 给我们创建对象
//        StuService stuService = app.getBean("stuService", StuService.class);
        StuService stuService = (StuService) app.getBean("stuService");

        // 调用对象的方法
        stuService.hello();

    }

}
