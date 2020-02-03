//IntelliJ IDEA
//ch5_2_3
//Person
//2020/2/3
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3.bean;

public class Person {
    private String name;
    private Integer age;
    public Person(){
        super();
    }
    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
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
}
