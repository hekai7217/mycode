package com.sxt.demo01.bean;

/**
 * @author 黄药师
 * @date 2020-08-12 14:39
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Car {

    private String brand;

    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public Car() {
    }

    public Car(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }
}
