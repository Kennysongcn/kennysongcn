package com.kennysongcn.providers.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennysongcn.providers.admin.mapper.user.UserInfoMapper;
import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.admin.service.user.UserInfoService;
import com.kennysongcn.providers.common.utils.PageInfo;



@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoMapper userMapper;


	@Override
	public List<UserInfo> getAllUser(UserInfo user, PageInfo page) {
		// TODO Auto-generated method stub
		List<UserInfo> result = userMapper.getAllUser(user,page);
		return result;
	}

	@Override
	public Integer getAllUserCount(UserInfo user) {
		// TODO Auto-generated method stub
		
		return userMapper.getAllUserCount(user);
	}

	@Override
	public UserInfo getUserInfoByLoginNameAndPwd(String loginName, String pwd) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(loginName);
		userInfo.setUserPwd(pwd);
		return userMapper.getUserInfoByLoginNameAndPwd(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo tempUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInfo getUserInfoByUserId(Integer userId) {
		UserInfo userInfo = userMapper.getUserByUserId(userId);
		return userInfo;
	}

}
