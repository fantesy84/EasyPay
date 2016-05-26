/**
 * Project: easypay-sys-domain
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.config.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 葛俊杰
 *
 */
@MappedSuperclass
public abstract class Configuration implements Serializable{
	private static final long serialVersionUID = -7095110448666913130L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONFIG_ID",unique=true,nullable=false)
	private Long configId;
	
	@Column(name="CONFIG_NAME",length=120)
	private String configName;
	
	@Column(name="CONFIG_TYPE",nullable=false,length=30)
	private String configType;
	
	@Column(name="IS_ACTIVE",nullable=false)
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME",nullable=false)
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_TIME",nullable=false)
	private Date updateTime;
	
	@Column(name="OPT_ID")
	private Long optId;
	
	@Column(name="DELETE_FLAG")
	private Boolean deleteFlag;
	/**
	 * @return the configId
	 */
	public Long getConfigId() {
		return configId;
	}
	/**
	 * @param configId the configId to set
	 */
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	/**
	 * @return the configName
	 */
	public String getConfigName() {
		return configName;
	}
	/**
	 * @param configName the configName to set
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	/**
	 * @return the configType
	 */
	public String getConfigType() {
		return configType;
	}
	/**
	 * @param configType the configType to set
	 */
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the optId
	 */
	public Long getOptId() {
		return optId;
	}
	/**
	 * @param optId the optId to set
	 */
	public void setOptId(Long optId) {
		this.optId = optId;
	}
	/**
	 * @return the deleteFlag
	 */
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
