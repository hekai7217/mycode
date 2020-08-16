package com.sxt.demo01.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:16
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Bean2 {
}

// 可以通过实现 FactoryBean 中的方法  通过getObject 获取对象
class BeanMyFactory implements FactoryBean<Bean2> {

    @Override
    public Bean2 getObject() throws Exception {
        return new Bean2();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
