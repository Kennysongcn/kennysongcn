package com.kennysongcn.providers.common.utils;

import org.apache.shiro.subject.Subject;

import com.kennysongcn.providers.common.model.ShiroUser;



public abstract class SecurityUtils {
	public static com.kennysongcn.providers.admin.model.user.UserInfo getLoginUser() {
		return getShiroUser().getUser();
	}
	
	public static ShiroUser getShiroUser() {
		Subject subject = getSubject();
		ShiroUser shiroUser = (ShiroUser)subject.getPrincipal();
		
		return shiroUser;
	}

	public static Subject getSubject() {
		return org.apache.shiro.SecurityUtils.getSubject();
	}
}
