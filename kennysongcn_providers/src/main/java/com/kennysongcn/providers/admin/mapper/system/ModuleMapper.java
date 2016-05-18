package com.kennysongcn.providers.admin.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kennysongcn.providers.admin.dto.ModuleDto;
import com.kennysongcn.providers.admin.model.system.Module;

@Component("moduleMapper")
public interface ModuleMapper {

	public List<ModuleDto> getTopModules();

	public List<ModuleDto> getChildModules(@Param("parentId")Integer parentId);

	public List<Module> getAllModules();

	public Module queryModuleByModuleId(Integer moduleId);

}
