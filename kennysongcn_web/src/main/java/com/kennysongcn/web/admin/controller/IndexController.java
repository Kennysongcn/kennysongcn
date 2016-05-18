/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ketayao.ketacustom.controller.IndexController.java
 * Class:			IndexController
 * Date:			2012-8-2
 * Author:			<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.kennysongcn.web.admin.controller;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kennysongcn.providers.common.model.ShiroUser;
import com.kennysongcn.providers.common.utils.SecurityUtils;
import com.kennysongcn.web.common.BaseController;

@Controller
@RequestMapping("/admin/index")
public class IndexController extends BaseController {
	
	private static final String INDEX = "admin/index";
	
	@RequiresUser
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) throws Exception{
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		model.addAttribute("login_user",shiroUser.getUser());
		return INDEX;
	}
	
}
