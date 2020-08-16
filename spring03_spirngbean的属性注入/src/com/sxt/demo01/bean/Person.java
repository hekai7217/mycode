package com.sxt.demo01.bean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:50
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   构造器的注入
 */
public class Person {

    private String name;
    private Integer age;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
