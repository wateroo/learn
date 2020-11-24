package com.watero.mapper;

import com.watero.entity.UserInfo;

public interface UserInfoMapper {
    public UserInfo selectUserInfoById(String acctId);
    public int insertUserInfo(UserInfo userInfo);
}
