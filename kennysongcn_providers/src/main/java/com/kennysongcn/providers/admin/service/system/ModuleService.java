package com.kennysongcn.providers.admin.service.system;

import java.util.List;

import com.kennysongcn.providers.admin.dto.ModuleDto;
import com.kennysongcn.providers.admin.model.system.Module;

public interface ModuleService {

	/**
	 * 获取顶级目录
	 * @return
	 */
	public List<ModuleDto> getTopModules();

	public List<ModuleDto> getChildModules(Integer parentId);

	public Module getModuleByModuleId(Integer moduleId);

	public ModuleDto getAllMenu();

}
