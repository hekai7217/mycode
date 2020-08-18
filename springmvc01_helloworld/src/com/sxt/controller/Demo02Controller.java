package com.sxt.controller;

/**
 * @author 黄药师
 * @date 2020-08-18 10:40
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   mvc的控制流程
 *  1. 所有的请求都通过 dispatchServlet
 *  2. 通过 handlermpper 对应的方法
 *
 *    请求url ---> 处理上面的方法
 *   http://localhost:8080/xxx/demo01 找到  Demo01Controller
 *   下面的方法
 *   返回 链 中 (请求和 方法的映射关系等其他信息 )
 *  3.handlerAdapter 找 处理器 handler
 *      handler 的处理器有多种实现方式:
 *        1.  实现接口 impl Controller
 *        2.  注解   @Controller
 *    handlerAdapter 的作用 不用的请求找到 handler的具体实现
 *
 *   4. handler 处理 请请求
 *        数据的处理器
 *
 *   5. 返回modelandView
 *
 *   6. 视图解析器 解析  ModelAndView
 *
 *   7. 数据给前端控制器, 前端控制器 把数据填充在 视图中
 *
 *   8. 返回视图给用户
 *
 *   前端控制器 :  mvc的核心
 *
 *   处理器映射器
 *   处理器适配器
 *   视图解析器
 *   mvc 已经提供了:
 *
 *   开发者需要做的是:
 *
 *       handler的处理器( 处理请求的方法 )
 *       view  数据的展示
 *
 **     处理器映射器
 *  *   处理器适配器
 *  *   视图解析器
 *    没有配置 怎么可以运行?
 *
 *    mvc下面有一个配置文件:
 *      会自动 配置 处理器映射器/处理器适配器/视图解析器
 *
 *    都可以自己配置 替代 mvc原有的配置:
 *
 *
 *
 *
 *
 */
public class Demo02Controller {
}
