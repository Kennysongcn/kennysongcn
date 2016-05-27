package com.kennysongcn.web.admin.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kennysongcn.providers.admin.dto.ModuleDto;
import com.kennysongcn.providers.admin.service.system.ModuleService;
import com.kennysongcn.web.common.BaseController;

/**
 * 处理模块处理逻辑
 * 
 * @author Freddy
 *
 */
@Controller
@RequestMapping(value = "/admin/module")
public class ModuleController extends BaseController {

	private static final String INDEX = "admin/module";// 模块管理页面

	@Autowired
	private ModuleService moduleService;

	@RequestMapping(value="getModules",method = RequestMethod.GET)
	@ResponseBody
	public List<ModuleDto>  getModules(Model model, Integer systemInfoId){
		List<ModuleDto> result = new ArrayList<ModuleDto>();
		ModuleDto moduleMenu = getModuleMenu(SecurityUtils.getSubject());
		result.add(moduleMenu);
		model.addAttribute(result);
		/*//获取所有顶级目录
		List<ModuleDto> modules= moduleService.getTopModules();
		for (ModuleDto module : modules) {
			//得到所有子目录
			List<ModuleDto> childModule =	getChildModules(module.getModuleId());
			module.setChildModule(childModule);
		} */
		return result;
		
	}
	private ModuleDto getModuleMenu(Subject subject){
		ModuleDto rootMenu = moduleService.getAllMenu();
		check(rootMenu,subject);
		return rootMenu;
		
	}
	private void check(ModuleDto rootMenu, Subject subject) {
		List<ModuleDto> list1 = new ArrayList<ModuleDto>();
		for (ModuleDto m1 : rootMenu.getChildModule()) {
			// 只加入拥有show权限的Module
			if (subject.isPermitted(m1.getModuleSn() + ":show")) {
				check(m1, subject);
				list1.add(m1);
			}
		}
		rootMenu.setChildModule(list1);
	}
	public List<ModuleDto>  getChildModules(Integer parentId){
		List<ModuleDto> childModule =	moduleService.getChildModules(parentId);
		return childModule;
	}
	
}
