package com.sxt.demo01.test;

/**
 * @author 黄药师
 * @date 2020-08-12 10:35
 * @desc 百战程序员 http://www.itbaizhan.com
 *   spring 的核心
 *
 *     ioc: 控制反转
 *       正控: 你需要创建一个对象  new 创建对象
 *       反控制: 创建对象的过程给spring
 *    springioc： 创建对象的权力给了spring
 *
 *    Di: spring创建对象的时候 通过spring的配置 给对象注入属性
 *           User
 *              name
 *              age
 *           以前创建对象:
 *                new User(name,age,car)
 *
 *           使用spring的di操作 (通过spring的配置给user注入属性)
 *           <bean id="car" class="com.sxt.bean.Car"></bean>
 *           ioc操作  创建对象的过程给了spring
 *           <bean id="user" class="com.sxt.bean.User">
 *               配置注入的操作
 *               <xxx 属性name 张三></>
 *               <xxx 属性age   30></>
 *               <xxx 属性car   car></>
 *           </bean>
 *
 *
 *
 */
public class Demo01SpringTest {
}
