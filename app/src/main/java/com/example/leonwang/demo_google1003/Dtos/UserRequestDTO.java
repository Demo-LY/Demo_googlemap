package com.example.leonwang.demo_google1003.Dtos;

import java.io.Serializable;

public class UserRequestDTO implements Serializable {

    private String patientCode;//病人编码
    private String devicesid; // 设备ID
    private String username; // 用户名
    private String passqord; // 秘码
    private String mobilephone; // 电话

    public String getDevicesid() {
        return devicesid;
    }

    public void setDevicesid(String devicesid) {
        this.devicesid = devicesid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassqord() {
        return passqord;
    }

    public void setPassqord(String passqord) {
        this.passqord = passqord;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

}