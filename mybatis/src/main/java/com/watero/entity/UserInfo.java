package com.watero.entity;

import java.util.Date;

public class UserInfo {
    private String acctId;
    private String acctName;
    private String nickName;
    private String password;
    private Date createTime;
    private Date lastUpdateTime;
    private boolean vip;

    public UserInfo() {
    }

    public UserInfo(String acctId, String acctName, String nickName, String password, Date createTime, Date lastUpdateTime, boolean vip) {
        this.acctId = acctId;
        this.acctName = acctName;
        this.nickName = nickName;
        this.password = password;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "acctId='" + acctId + '\'' +
                ", acctName='" + acctName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", vip=" + vip +
                '}';
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}

