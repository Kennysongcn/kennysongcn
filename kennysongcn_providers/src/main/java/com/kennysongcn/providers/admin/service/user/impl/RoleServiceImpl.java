package com.kennysongcn.providers.admin.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennysongcn.providers.admin.mapper.user.RoleMapper;
import com.kennysongcn.providers.admin.mapper.user.UserInfoMapper;
import com.kennysongcn.providers.admin.model.user.Role;
import com.kennysongcn.providers.admin.service.user.RoleService;
import com.kennysongcn.providers.common.utils.PageInfo;


@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		
		return roleMapper.getAllRole();
	}
	@Override
	public List<Role> getListAllRole(Role role, PageInfo page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getListAllRoleCount(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Role> getUserRolesByUserId(Integer userId) {
		List<Role> roleList = new ArrayList<Role>();
		/*
		 * 1. 获取用户自身所拥有的角色信息 
		 */
		List<Role> roleList1 = roleMapper.getUserRolesByUserId(userId);// 用户自身所拥有的角色信息
		roleList.addAll(roleList1);
		return roleList;
	}
	@Override
	public List<Role> getRolesByPositionId(Integer position) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> editRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void bindUserToRole(Integer roleId, String userIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unBindUserToRole(Integer roleId, String userIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bindPositionToRole(Integer roleId, String positionIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unBindPositionToRole(Integer roleId, String positionIds) {
		// TODO Auto-generated method stub
		
	}
	
}
