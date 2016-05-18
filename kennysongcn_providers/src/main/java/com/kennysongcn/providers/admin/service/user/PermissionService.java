package com.kennysongcn.providers.admin.service.user;

import java.util.List;
import java.util.Map;

import com.kennysongcn.providers.admin.model.system.Permission;

public interface PermissionService {

	List<Permission> getPermissionByRoleId(Integer roleId);

	List<Permission> getPermissionByModuleId(Integer moduleId);

	Map<String,Object> addPermission(Permission permission);

	void bindPermissionToRole(Integer roleId, String permissionIds);
	
	
}
