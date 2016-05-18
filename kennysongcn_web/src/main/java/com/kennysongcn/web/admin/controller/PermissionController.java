package com.kennysongcn.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kennysongcn.providers.admin.service.user.PermissionService;
import com.kennysongcn.web.common.BaseController;

@Controller
@RequestMapping(value="/manage/permission")
public class PermissionController extends BaseController {
	
	@Autowired
	private PermissionService permissionService;
	

}
