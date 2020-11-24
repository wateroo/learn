package com.watero.entity;

import java.util.Date;

public class OrderInfo {
    private Long id;
    private Date createTime;
    private String userId;
    private Long goodId;
    private Long addressId;
    private Date updateTime;

    public OrderInfo(Long id, Date createTime, String userId, Long goodId, Long addressId, Date updateTime) {
        this.id = id;
        this.createTime = createTime;
        this.userId = userId;
        this.goodId = goodId;
        this.addressId = addressId;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", userId='" + userId + '\'' +
                ", goodId=" + goodId +
                ", addressId=" + addressId +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
