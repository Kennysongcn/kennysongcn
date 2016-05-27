package com.kennysongcn.web.common.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kennysongcn.providers.admin.model.system.Module;
import com.kennysongcn.providers.admin.model.system.Permission;
import com.kennysongcn.providers.admin.model.user.Role;
import com.kennysongcn.providers.admin.service.system.ModuleService;
import com.kennysongcn.providers.admin.service.user.PermissionService;
import com.kennysongcn.providers.admin.service.user.RoleService;
import com.kennysongcn.providers.admin.service.user.UserInfoService;
import com.kennysongcn.providers.common.model.ShiroUser;


public class ShiroDbRealm extends AuthorizingRealm {
	private static final Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);

	private static final int INTERATIONS = 1024;
	private static final String ALGORITHM = "SHA-1";

	// 是否启用超级管理员
	protected boolean activeRoot = false;

	protected UserInfoService userInfoService;
	protected RoleService roleService;
	protected PermissionService permissionService;
	protected ModuleService moduleService;
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}


	/**
	 * 给ShiroDbRealm提供编码信息，用于密码密码比对 描述
	 */
	public ShiroDbRealm() {
		super();
		/*
		 * HashedCredentialsMatcher matcher = new
		 * HashedCredentialsMatcher(ALGORITHM);
		 * matcher.setHashIterations(INTERATIONS);
		 * setCredentialsMatcher(matcher);
		 */
		setCredentialsMatcher(new OACredentialsMatcher());
	}

	/**
	 * 认证回调函数, 登录时调用.
	 */
	// TODO 对认证进行缓存处理
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

//		UserInfo user = userInfoService.getUserByLoginName(token.getUsername());
//		if (user != null) {
//			ShiroUser shiroUser = new ShiroUser(user.getUserInfoId(), user.getLoginName());
//
//			SimpleAuthenticationInfo(shiroUser, user.getLoginPwd(), null, getName());
//		} else {
//			return null;
//		}
		ShiroUser shiroUser = new ShiroUser();
		shiroUser.setLoginName(token.getUsername());
		return new SimpleAuthenticationInfo(shiroUser, String.valueOf(token.getPassword()), null, getName());
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Collection<?> collection = principals.fromRealm(getName());
		if (collection == null || collection.isEmpty()) {
			return null;
		}
		ShiroUser shiroUser = (ShiroUser) collection.iterator().next();
		// 设置、更新User
		shiroUser.setUser(userInfoService.getUserInfoByUserId(shiroUser.getId()));
		return newAuthorizationInfo(shiroUser);
	}

	@SuppressWarnings("unused")
	private SimpleAuthorizationInfo newAuthorizationInfo(ShiroUser shiroUser) {
		Collection<String> hasPermissions = null;
		Collection<String> hasRoles = null;

		// 是否启用超级管理员 && id==1为超级管理员，构造所有权限
		if (activeRoot && false) {
			hasRoles = new HashSet<String>();
			List<Role> roles = roleService.getAllRole();
			for (Role role : roles) {
				hasRoles.add(role.getRoleName());
			}
			hasPermissions = new HashSet<String>();
			hasPermissions.add("*");

			if (log.isInfoEnabled()) {
				log.info("使用了" + shiroUser.getLoginName() + "的超级管理员权限:" + "。At " + new Date());
				log.info(shiroUser.getLoginName() + "拥有的角色:" + hasRoles);
				log.info(shiroUser.getLoginName() + "拥有的权限:" + hasPermissions);
			}
		} else {
			Collection<Role> roles = roleService.getUserRolesByUserId(shiroUser.getId());
			hasRoles = makeRoles(roles, shiroUser);
			hasPermissions = makePermissions(roles, shiroUser);
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(hasRoles);
		info.addStringPermissions(hasPermissions);
		return info;
	}

	/**
	 * 组装角色权限
	 * 
	 * @param roles
	 * @param shiroUser
	 * @return
	 */
	private Collection<String> makeRoles(Collection<Role> roles, ShiroUser shiroUser) {
		Collection<String> hasRoles = new HashSet<String>();
		for (Role role : roles) {
			hasRoles.add(role.getRoleName());
		}

		if (log.isInfoEnabled()) {
			log.info(shiroUser.getLoginName() + "拥有的角色:" + hasRoles);
		}
		return hasRoles;
	}

	/**
	 * 组装资源操作权限
	 * 
	 * @param roles
	 * @param shiroUser
	 * @return
	 */
	private Collection<String> makePermissions(Collection<Role> roles, ShiroUser shiroUser) {
		// 清空shiroUser中map
		shiroUser.getHasModules().clear();

		Collection<String> stringPermissions = new ArrayList<String>();
		for (Role role : roles) {
			List<Permission> permissions = permissionService.getPermissionByRoleId(role.getRoleId());
			for (Permission permission : permissions) {
				Module module = moduleService.getModuleByModuleId(permission.getModuleId());
				String resource = module.getModuleSn();
				String operate = permission.getPermissionSn();

				StringBuilder builder = new StringBuilder();
				builder.append(resource + ":" + operate);
				shiroUser.getHasModules().put(resource, module);
				StringBuilder dcBuilder = new StringBuilder();
				if (dcBuilder.length() > 0) {
					builder.append(":" + dcBuilder.substring(0, dcBuilder.length() - 1));
				}
				stringPermissions.add(builder.toString());
			}
		}

		if (log.isInfoEnabled()) {
			log.info(shiroUser.getLoginName() + "拥有的权限:" + stringPermissions);
		}
		return stringPermissions;
	}

	public static class HashPassword {
		public String salt;
		public String password;
	}

	/*
	 * 覆盖父类方法，设置AuthorizationCacheKey为ShiroUser的loginName，这样才能顺利删除shiro中的缓存。
	 * 因为shiro默认的AuthorizationCacheKey为PrincipalCollection的对象。
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#getAuthorizationCacheKey(org.
	 * apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		return shiroUser.getLoginName();
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String loginName) {
		ShiroUser shiroUser = new ShiroUser(loginName);

		SimplePrincipalCollection principals = new SimplePrincipalCollection(shiroUser, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 设置 isActiveRoot 的值
	 * 
	 * @param isActiveRoot
	 */
	public void setActiveRoot(boolean activeRoot) {
		this.activeRoot = activeRoot;
	}


	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

}
