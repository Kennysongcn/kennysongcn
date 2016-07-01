package com.kennysongcn.web.admin.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.admin.service.user.UserInfoService;
import com.kennysongcn.providers.common.model.ShiroUser;
import com.kennysongcn.providers.common.utils.PageInfo;
import com.kennysongcn.providers.common.utils.SecurityUtils;
import com.kennysongcn.web.common.BaseController;

/**
 * 用户信息管理业务逻辑处理
 * @author songzhihao
 *
 */
@Controller
@RequestMapping(value="/admin/manage/users")
public class UserInfoController extends BaseController {
	
	private static final String INDEX = "admin/users/index";//用户信息主页
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequiresUser
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) throws Exception{
		return INDEX;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> getAllUser(Model model,UserInfo userInfo,PageInfo page){
		int count = userInfoService.getAllUserCount(userInfo);
		List <UserInfo> list = userInfoService.getAllUser(userInfo,page);
		Map<String , Object> hashMap=new HashMap<String , Object>();
		hashMap.put("total", count);
		hashMap.put("rows", list);
		return hashMap;
    	
    }
	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> getUserInfoByUserId(Model model,@PathVariable Integer userId,UserInfo userInfo,PageInfo page){
		UserInfo userInfoTemp = userInfoService.getUserInfoByUserId(userId);
		Map<String , Object> hashMap=new HashMap<String , Object>();
		hashMap.put("success", true);
		hashMap.put("data", userInfoTemp);
		return hashMap;
    	
    }
}
