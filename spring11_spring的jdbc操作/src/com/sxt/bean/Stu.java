package com.sxt.bean;

/**
 * @author 黄药师
 * @date 2020-08-14 15:43
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Stu {

    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Stu() {
    }

    public Stu(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
