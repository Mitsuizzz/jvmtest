package com.mitsui.jvmtest.entity;

/**
 * @program: jvmtest
 * @description:
 * @author: mitsuizzz
 * @create: 2021-05-20 14:33
 **/
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
