/**
 * Project easypay-schedule-domain
 * CreateTime: 2016年4月29日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.easypay.job.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TypeName: ScheduleJob
 * 
 * <P>CreateTime: 2016年4月29日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@Entity
@Table(name="EP_SYS_SCHEDULERS")
public class ScheduleJob implements Serializable {
	private static final long serialVersionUID = 6829954866106566140L;
	private String scheduleName;
	private String jobName;
	private String jobGroup;
	private String description;
	/**
	 * @return the scheduleName
	 */
	public String getScheduleName() {
		return scheduleName;
	}
	/**
	 * @param scheduleName the scheduleName to set
	 */
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}
	/**
	 * @param jobGroup the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
