package com.kennysongcn.web.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kennysongcn.providers.admin.model.user.UserInfo;
import com.kennysongcn.providers.admin.service.user.UserInfoService;
import com.kennysongcn.providers.common.utils.PageInfo;
import com.kennysongcn.web.common.BaseController;

/**
 * 用户信息管理业务逻辑处理
 * @author Freddy
 *
 */
@Controller
@RequestMapping(value="/admin/user")
public class UserInfoController extends BaseController {
	
	private static final String INDEX = "manage/userinfo";//用户信息主页
	
	@Autowired
	private UserInfoService userInfoService;
	
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
}
