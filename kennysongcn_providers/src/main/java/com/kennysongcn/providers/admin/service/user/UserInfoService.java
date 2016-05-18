package com.kennysongcn.providers.admin.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.common.utils.PageInfo;


public interface UserInfoService {


	public List<UserInfo> getAllUser(@Param("user") UserInfo user, @Param("page") PageInfo page);

	public Integer getAllUserCount(UserInfo user);

	public UserInfo getUserInfoByLoginNameAndPwd(String loginName, String userCode);

	public void updateUserInfo(UserInfo tempUser);

	public UserInfo getUserByUserId(Integer id);


}
