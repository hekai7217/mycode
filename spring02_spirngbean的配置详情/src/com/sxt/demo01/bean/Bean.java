package com.sxt.demo01.bean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:10
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Bean {

}

// 创建bean的工厂
// 在spring中配置静态工厂方法 创建对象
class BeanFactory{
    public static Bean getBeanFactory(){

        // 可以在这里进行初始化操作

        return new Bean();
    }
}
