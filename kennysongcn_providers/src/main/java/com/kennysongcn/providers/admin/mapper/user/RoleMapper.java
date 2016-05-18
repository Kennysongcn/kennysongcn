package com.kennysongcn.providers.admin.mapper.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kennysongcn.providers.admin.model.user.Role;

@Component("roleMapper")
public interface RoleMapper {

	public List<Role> getAllRole();

	public List<Role> getUserRolesByUserId(Integer userId);

}
