package com.bruce.module.mybatis.entity;

import java.util.Date;

/**
 * Created by Mr.Bruce on 2017/12/13.
 */
public class User {
    private String id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User(String username, Date birthday, String sex, String address) {
        super();
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }
    public User(String id, String username, Date birthday, String sex,
                String address) {
        super();
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
