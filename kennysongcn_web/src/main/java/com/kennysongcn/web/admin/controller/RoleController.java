package com.kennysongcn.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kennysongcn.providers.admin.service.user.RoleService;
import com.kennysongcn.web.common.BaseController;

/**
 * 角色处理对应的Controller
 * 
 * @author LuZhilong
 */
@Controller
@RequestMapping(value = "/manage/role")
public class RoleController extends BaseController {

	private static final String INDEX = "manage/role";// 角色管理首页

	@Autowired
	private RoleService roleService;

}
