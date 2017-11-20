package com.example.ssh.domain;

/**
 * Created by Administrator on 2017/11/16.
 */
public class User {
    private String name;
    private Long id;
    private int age;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserMapping{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
