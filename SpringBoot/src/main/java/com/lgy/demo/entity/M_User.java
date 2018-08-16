package com.lgy.demo.entity;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/15 15:56
 *@description:
测试insert数据的实体类
 */
public class M_User {
    private int userId;
    private String userName;
    private String password;
    private String phone;

    public M_User() {
    }

    public M_User(int userId, String userName, String password, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
