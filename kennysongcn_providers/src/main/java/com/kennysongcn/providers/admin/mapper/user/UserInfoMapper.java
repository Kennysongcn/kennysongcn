package com.kennysongcn.providers.admin.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.common.utils.PageInfo;


@Component("userInfoMapper")
public interface UserInfoMapper {
	
	public List<UserInfo> getAllUser(@Param("user") UserInfo user, @Param("page") PageInfo page);

	public Integer getAllUserCount(UserInfo user);

	public UserInfo getUserInfoByLoginNameAndPwd(UserInfo userInfo);

	public UserInfo getUserByUserId(Integer id);

}
