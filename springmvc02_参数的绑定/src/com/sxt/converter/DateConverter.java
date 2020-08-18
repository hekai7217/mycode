package com.sxt.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-08-18 14:52
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   手动转换器   实现
 *   01  org.springframework.core.convert.converter.Converter;
 *   02 需要注册
 *        在mvc的配置文件中注册
 *
 *    String,Date 泛型
 *    String 输入的字符串
 *    Date   装换后返回的字符串
 *
 */
public class DateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {

        // yyyy-MM-dd 转成date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date= sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
