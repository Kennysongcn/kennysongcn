package com.kennysongcn.providers.admin.model.system;

import java.util.Date;

public class Module {
	private Integer moduleId;
	private String moduleName;
	private String moduleSn;
	private String moduleUrl;
	private Integer parentModuleId;
	private Date createTime;
	private Date updateTime;
	private String icon;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
}
