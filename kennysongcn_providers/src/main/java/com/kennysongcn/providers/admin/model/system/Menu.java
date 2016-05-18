package com.kennysongcn.providers.admin.model.system;

import java.util.List;

import com.kennysongcn.providers.admin.dto.PermissionDto;

public class Menu {
	private Integer id;
	private String text;
	private String sn;
	private String moduleUrl;
	private Integer ParentModuleId;
	private List<Menu> children;
	private List<PermissionDto> permissions;
	private Integer systemInfoId;
	private String icon;

	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	
	public Integer getParentModuleId() {
		return ParentModuleId;
	}
	public void setParentModuleId(Integer parentModuleId) {
		ParentModuleId = parentModuleId;
	}
}
