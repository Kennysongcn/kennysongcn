package com.kennysongcn.providers.admin.mapper.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kennysongcn.providers.admin.model.system.Permission;

@Component("permissionMapper")
public interface PermissionMapper{

	public List<Permission> getPermissionByRoleId(Integer roleId);
	
}
