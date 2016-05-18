package com.kennysongcn.web.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.PrincipalCollection;

import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.admin.service.user.UserInfoService;
import com.kennysongcn.providers.common.model.ShiroUser;
import com.kennysongcn.providers.common.utils.MD5Util;
import com.kennysongcn.providers.common.utils.SpringContextUtil;


/**
 * 自定义密码验证
 * 链接oa系统进行用户登录认证
 * 
 * @author LuZhilong
 */
public class OACredentialsMatcher extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = String.valueOf(usernamePasswordToken.getPassword());
		String loginpwd = MD5Util.GetMD5Code(password);// 获取MD5加密密码.toUpperCase()
		boolean result = false;
		
		//首先查询当前登陆名称在本地数据库是否存在
		UserInfoService userInfoService = (UserInfoService) SpringContextUtil.getBean("userInfoService");
		UserInfo tempUser = userInfoService.getUserInfoByLoginNameAndPwd(username,password);
		//更新ShiroUser
		PrincipalCollection collection =  info.getPrincipals();
		ShiroUser shiroUser = (ShiroUser) collection.iterator().next();
		//有则更新数据
		if(tempUser!=null){
			//tempUser.setUpdateTime(new Date());
			userInfoService.updateUserInfo(tempUser);
			shiroUser.setId(tempUser.getUserId());
			shiroUser.setUser(tempUser);
			result = true;
			//loginUser = tempUser;
		}else{
			result = false;
		}
		/*if(tempUser==null){
			//没有则新增一条数据
			tempUser.setCreateTime(new Date());
			userInfoService.saveUser(tempUser);
		}*/


		return result;
	}

	/**
	 * 该方法当oa链接不上的时候，做测试使用，用户只需输入用户名即可登录
	 * 该方法超级不安全
	 */
	/*public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = String.valueOf(usernamePasswordToken.getPassword());
		String loginpwd = MD5Util.GetMD5Code(password);// 获取MD5加密密码.toUpperCase()
		boolean result = false;
		//首先查询当前登陆名称在本地数据库是否存在
		UserInfoService userInfoService = (UserInfoService) SpringContextUtil.getBean("userInfoService");
		UserInfo tempUser = userInfoService.getUserByLoginName(username);
		//更新ShiroUser
		PrincipalCollection collection =  info.getPrincipals();
		ShiroUser shiroUser = (ShiroUser) collection.iterator().next();
		if(tempUser!= null){
			shiroUser.setId(tempUser.getUserInfoId());
			shiroUser.setUser(tempUser);
			result = true;
		}else{
			result = false;
		}
		return result;
	}*/
}
