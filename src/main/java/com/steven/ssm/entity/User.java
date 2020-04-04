package com.steven.ssm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private String userPhone;
    private Long userType;
    private String userPhoto;
    private Long userSex;
    private String userAddress;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date userBirthday;
    private String userEmail;
    private String userDescribe;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public Long getUserType() {
        return userType;
    }
    public void setUserType(Long userType) {
        this.userType = userType;
    }
    public String getUserPhoto() {
        return userPhoto;
    }
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
    public Long getUserSex() {
        return userSex;
    }
    public void setUserSex(Long userSex) {
        this.userSex = userSex;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public Date getUserBirthday() {
        return userBirthday;
    }
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserDescribe() {
        return userDescribe;
    }
    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }
}