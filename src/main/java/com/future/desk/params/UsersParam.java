package com.future.desk.params;


/**
 * @author: stone
 * @create: 2019-07-04 09:46
 **/
public class UsersParam {

    private Integer id;
    private String phone;//注册必须
    private String nickname;
    private Integer sex;
    private String token;
    private String deviceId;//设备ID
    private String verifiCode;//注册必须

    public UsersParam(Integer id,String phone, String nickname, Integer sex, String token) {
        this.id = id;
        this.phone = phone;
        this.nickname = nickname;
        this.sex = sex;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVerifiCode() {
        return verifiCode;
    }

    public void setVerifiCode(String verifiCode) {
        this.verifiCode = verifiCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

    
