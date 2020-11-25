package com.watero.service;

import com.github.pagehelper.PageInfo;
import com.watero.entity.User;

public interface AdminService {

	User queryUserByAcctId(String acctId, String userPasswd);

	PageInfo<User> getUserListPageInfo(User user ,int pageNum,int pageSize);

}
