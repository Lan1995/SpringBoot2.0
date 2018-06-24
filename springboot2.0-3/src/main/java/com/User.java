package com;

import java.util.List;

public class User {

    private String username;

    private int age;

    private List<LinkAddress> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<LinkAddress> getList() {
        return list;
    }

    public void setList(List<LinkAddress> list) {
        this.list = list;
    }
}
