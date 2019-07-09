package com.future.desk.model;

import java.io.Serializable;

/**
 *  用户类
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String phone;
    private String nickname;
    private int sex = 0;
    private String token;

    public Users(){}

    public Users( String phone) {
        this.phone = phone;
        this.nickname = phone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", phone=" + phone +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", token='" + token + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


