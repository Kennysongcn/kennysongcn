package com.kennysongcn.providers.admin.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennysongcn.providers.admin.dto.ModuleDto;
import com.kennysongcn.providers.admin.mapper.system.ModuleMapper;
import com.kennysongcn.providers.admin.model.system.Menu;
import com.kennysongcn.providers.admin.model.system.Module;
import com.kennysongcn.providers.admin.service.system.ModuleService;
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<ModuleDto> getTopModules() {
		List<ModuleDto> topModule = moduleMapper.getTopModules();
		return topModule;
	}

	@Override
	public List<ModuleDto> getChildModules(Integer parentId) {
		List<ModuleDto> childModule = moduleMapper.getChildModules(parentId);
		return childModule;
	}

	@Override
	public Module getModuleByModuleId(Integer moduleId) {
		// TODO Auto-generated method stub
		return moduleMapper.queryModuleByModuleId(moduleId);
	}

	@Override
	public ModuleDto getAllMenu() {
		// TODO Auto-generated method stub
		List<Module>  moduleList =moduleMapper.getAllModules();
		   List<ModuleDto> list = new ArrayList<ModuleDto>();
	        for(Module module : moduleList){
	        	ModuleDto m = new ModuleDto();
	            m.setModuleId(module.getModuleId());
	            m.setModuleName(module.getModuleName());
	            m.setModuleUrl(module.getModuleUrl());
	            m.setModuleSn(module.getModuleSn());
	            m.setParentModuleId(module.getParentModuleId());
	            m.setIcon(module.getIcon());
	            list.add(m);
	        }
	        List<ModuleDto> rootList = makeTree(list);
	        return rootList.get(0);
	}
	/**
	 * 创建顶级节点
	 * @param moduleList
	 * @return
	 */
	private List<ModuleDto> makeTree(List<ModuleDto> moduleList) {
		List<ModuleDto> menuParent = new ArrayList<ModuleDto>();
		for(ModuleDto e: moduleList){
			//如果当前节点的父类ID为空，则为顶级节点，
			if(e.getParentModuleId() == null){
				e.setChildModule(new ArrayList<ModuleDto>(0));
				menuParent.add(e);
			}
		}
		//移除root节点剩下子节点
		moduleList.removeAll(menuParent);
		//创建子节点 
		makeChildren(menuParent,moduleList);
		return menuParent;
	}
	
	private void makeChildren(List<ModuleDto> menuParent, List<ModuleDto> childList) {
		if(childList.isEmpty()){
			return;
		}
		List<ModuleDto> tmp = new ArrayList<ModuleDto>();
		//循环子节点和父类节点
		for(ModuleDto p : menuParent){
			for(ModuleDto c : childList){
				//如果父类节点ID和当前节点ID相同，则创建子节点，同时添加子节点到跟父节点
				if(c.getParentModuleId().equals(p.getModuleId())){
					c.setChildModule(new ArrayList<ModuleDto>(0));
					p.getChildModule().add(c);
					tmp.add(c);
				}
			}
		}
		childList.removeAll(tmp);
		
		makeChildren(tmp, childList);
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.get(0);
	}
}
