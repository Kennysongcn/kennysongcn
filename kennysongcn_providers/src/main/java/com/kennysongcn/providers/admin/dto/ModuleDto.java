package com.kennysongcn.providers.admin.dto;

import java.util.Date;
import java.util.List;

public class ModuleDto {
	private Integer moduleId;
	private String moduleName;
	private String moduleSn;
	private String moduleUrl;
	private Integer parentModuleId;
	private Date createTime;
	private Date updateTime;
	private String icon;
	private List<ModuleDto>childModule;
	private List<PermissionDto> permissions;
	private Integer systemInfoId;
	
	public List<PermissionDto> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionDto> permissions) {
		this.permissions = permissions;
	}
	public Integer getSystemInfoId() {
		return systemInfoId;
	}
	public void setSystemInfoId(Integer systemInfoId) {
		this.systemInfoId = systemInfoId;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleSn() {
		return moduleSn;
	}
	public void setModuleSn(String moduleSn) {
		this.moduleSn = moduleSn;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public Integer getParentModuleId() {
		return parentModuleId;
	}
	public void setParentModuleId(Integer parentModuleId) {
		this.parentModuleId = parentModuleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<ModuleDto> getChildModule() {
		return childModule;
	}
	public void setChildModule(List<ModuleDto> childModule) {
		this.childModule = childModule;
	}
	
	
}
