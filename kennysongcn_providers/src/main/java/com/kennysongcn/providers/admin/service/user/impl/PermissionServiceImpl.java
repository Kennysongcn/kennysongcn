package com.kennysongcn.providers.admin.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennysongcn.providers.admin.mapper.user.PermissionMapper;
import com.kennysongcn.providers.admin.model.system.Permission;
import com.kennysongcn.providers.admin.service.user.PermissionService;


@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> getPermissionByRoleId(Integer roleId) {
		return permissionMapper.getPermissionByRoleId(roleId);
	}

	@Override
	public List<Permission> getPermissionByModuleId(Integer moduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> addPermission(Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindPermissionToRole(Integer roleId, String permissionIds) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
