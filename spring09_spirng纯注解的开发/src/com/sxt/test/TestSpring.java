package com.sxt.test;

/**
 * @author 黄药师
 * @date 2020-08-14 15:10
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    spring 核心 ioc 和di
 *
 *    ioc : 创建对象的权限交个了spring
 *       创建对象添加到ioc实现的方式:
 *
 *    1. <bean id="xxx" class="xxx"></bean>  使用标签创建对象 交给ioc容器管理
 *    2.  注解(Component/controller 等等等) + 扫描  使用注解 + 扫描
 *          问题? 数据库连接的配置 不能用这些注解
 *    3. java 代码创建对象 + @bean 标签   创建对象交个ioc容器管理
 *           案例: dataSource 连接池java创建对象 + @Bean 标签
 *
 *    Di: 对象的属性依赖 交给了spring
 *        xml:
 *           set注入
 *             <bean>
 *                 <property name="属性名称" value/ref></property>
 *             </bean>
 *              前提 要有set方法
 *           构造器的注入
 *                        constructor-arg  构造器的 参数名称
                 *        index     第几个参数  从0开始
                 *        name     构造器参数名称
                 *        value    参数的值
                 *        type    参数的数据类型
   *                          index和name 属性二选一
                 *
                 *        如果没有对应的参数构造器 配置会报错
                 *        type 可以省略 会自动判断类型
                 *        name的名称 一定要 bean的属性名称一致
                 *
                 *        如果有引用类型    value改成 ref
 *
 *        注解:
 *            2个解决方案:
 *              1. @autowride +Qualifiter
 *              2. @Resource
 *
 *    spring 的纯注解开发:
 *
 *
 */
public class TestSpring {
}
