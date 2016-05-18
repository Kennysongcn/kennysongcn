package com.kennysongcn.providers.admin.model.system;

/**
 * 系统配置表
 * @author LuZhilong
 *
 */
public class SysConfig {
	private Integer sysConfigId;
	private String configCode;
	private String module;
	private String sysKey;
	private String sysValue;
	private String sysDesc;
	private Integer memory;
	private Integer enableFlag;
	private String propId;
	public Integer getSysConfigId() {
		return sysConfigId;
	}
	public void setSysConfigId(Integer sysConfigId) {
		this.sysConfigId = sysConfigId;
	}
	public String getConfigCode() {
		return configCode;
	}
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getSysKey() {
		return sysKey;
	}
	public void setSysKey(String sysKey) {
		this.sysKey = sysKey;
	}
	public String getSysValue() {
		return sysValue;
	}
	public void setSysValue(String sysValue) {
		this.sysValue = sysValue;
	}
	public String getSysDesc() {
		return sysDesc;
	}
	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}
	public Integer getMemory() {
		return memory;
	}
	public void setMemory(Integer memory) {
		this.memory = memory;
	}
	public Integer getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(Integer enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getPropId() {
		return propId;
	}
	public void setPropId(String propId) {
		this.propId = propId;
	}
}
