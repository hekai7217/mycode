package com.sxt.cglib;

import com.sxt.service.UserServiceImpl;
import com.sxt.utils.TrsactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 黄药师
 * @date 2020-08-15 11:29
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *     这里的操作 和 jdk的动态代理基本一样的
 *
 *     1. 传入 真实对象
 *     2. 传入通知类型  增强方法的类型
 *     3. 创建代理对象
 *         Enhancer 创建代理对象
 *
 */
@Component
public class CglibProxyHandler {

    @Autowired
    private UserServiceImpl userService;

    // 通知类型
    @Autowired
    private TrsactionManager tm;

    public <T> T getProxyObj(Class<T> cls){

        //创建enhancer 对象
        Enhancer enhancer = new Enhancer();

        // 设置 类型加载器
        enhancer.setClassLoader(userService.getClass().getClassLoader());

        // enhancer 设置 代理对象的父类
        //  cglib 创建了一个子类 重写方法进行扩展
        // 告诉 cglib通过那个类创建 子类
        enhancer.setSuperclass(userService.getClass());

        // 设置 方法调用
        // 真实对象方法的调用
        // 创建 一个 内部类  代理对象的处理
        // 这里的写法和 jdk的一样的
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {

                // 真实对象的方法
                Object result = null;
                try {
                    tm.begin();
                    result = method.invoke(userService, args);
                    tm.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    tm.rollback();
                } finally {
                    tm.close();
                }

                return result;
            }
        });

        //创建代理对象
        Object o = enhancer.create();

        return (T) o;

    }
}
