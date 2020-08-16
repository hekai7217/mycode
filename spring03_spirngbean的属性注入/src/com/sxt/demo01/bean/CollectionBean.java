package com.sxt.demo01.bean;

import org.springframework.core.env.PropertiesPropertySource;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 黄药师
 * @date 2020-08-12 15:23
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class CollectionBean {

    // set
    private Set<String> set;

    // List
    private List<String> list;

    private List<Car> cars;

    // Map
    private Map<String,String> map;

    private Properties props; // 和db.perproties 和map一样

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
