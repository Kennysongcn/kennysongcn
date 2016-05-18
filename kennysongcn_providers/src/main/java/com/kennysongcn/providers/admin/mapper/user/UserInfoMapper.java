package com.kennysongcn.providers.admin.mapper.user;

import org.springframework.stereotype.Component;

import com.kennysongcn.providers.admin.model.user.UserInfo;


@Component("userInfoMapper")
public interface UserInfoMapper {
	
/*	public List<UserInfo> getAllUser(@Param("user") UserInfo user, @Param("page") PageInfo page);

	public Integer getAllUserCount(UserInfo user);*/

	public UserInfo getUserInfoByLoginNameAndPwd(UserInfo userInfo);

	public UserInfo getUserByUserId(Integer id);

}
