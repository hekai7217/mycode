package com.sxt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 黄药师
 * @date 2020-08-21 15:54
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Data  // 提供set /get方法
@NoArgsConstructor // 空构造
@AllArgsConstructor // 有参构造器
public class User {
    private String name;
    private Integer age;
}
