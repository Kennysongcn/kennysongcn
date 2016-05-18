package com.kennysongcn.providers.admin.service.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kennysongcn.providers.admin.model.user.Role;
import com.kennysongcn.providers.common.utils.PageInfo;

public interface RoleService {

	/**
	 * 获取所有角色
	 * @return
	 */
	public List<Role> getAllRole();
	
	public List<Role> getListAllRole(@Param("role")Role role,@Param("page")PageInfo page);

	public Integer getListAllRoleCount(Role role);
	
	public List<Role> getUserRolesByUserId(Integer userId);
	
	public List<Role> getRolesByPositionId(Integer position);

	public Map<String, Object> addRole(Role role);

	public Map<String, Object> editRole(Role role);

	public void bindUserToRole(Integer roleId, String userIds);

	public void unBindUserToRole(Integer roleId, String userIds);

	public void bindPositionToRole(Integer roleId, String positionIds);

	public void unBindPositionToRole(Integer roleId, String positionIds);
	
}
