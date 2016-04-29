package net.fantesy84.easypay.job.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "EP_SYS_SCHEDULERS", catalog = "EASY_PAY")
public class EpSysSchedulers implements java.io.Serializable {
	private static final long serialVersionUID = 4142293657938927105L;
	private String scheduleName;
	private int version;
	private String jobName;
	private String jobGroup;
	private String triggerName;
	private String triggerGroup;
	private String triggerType;
	private String triggerExpression;
	private Date createTime;
	private Date updateTime;
	private Boolean deleteFlag;

	public EpSysSchedulers() {
	}

	public EpSysSchedulers(String scheduleName, String jobName, String jobGroup, String triggerName,
			String triggerGroup, String triggerType, String triggerExpression, Date createTime) {
		this.scheduleName = scheduleName;
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.triggerName = triggerName;
		this.triggerGroup = triggerGroup;
		this.triggerType = triggerType;
		this.triggerExpression = triggerExpression;
		this.createTime = createTime;
	}

	public EpSysSchedulers(String scheduleName, String jobName, String jobGroup, String triggerName,
			String triggerGroup, String triggerType, String triggerExpression, Date createTime, Date updateTime,
			Boolean deleteFlag) {
		this.scheduleName = scheduleName;
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.triggerName = triggerName;
		this.triggerGroup = triggerGroup;
		this.triggerType = triggerType;
		this.triggerExpression = triggerExpression;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	@Id

	@Column(name = "SCHEDULE_NAME", unique = true, nullable = false, length = 120)
	public String getScheduleName() {
		return this.scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "JOB_NAME", nullable = false, length = 120)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(name = "JOB_GROUP", nullable = false, length = 120)
	public String getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	@Column(name = "TRIGGER_NAME", nullable = false, length = 120)
	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	@Column(name = "TRIGGER_GROUP", nullable = false, length = 120)
	public String getTriggerGroup() {
		return this.triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	@Column(name = "TRIGGER_TYPE", nullable = false, length = 7)
	public String getTriggerType() {
		return this.triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	@Column(name = "TRIGGER_EXPRESSION", nullable = false, length = 800)
	public String getTriggerExpression() {
		return this.triggerExpression;
	}

	public void setTriggerExpression(String triggerExpression) {
		this.triggerExpression = triggerExpression;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "DELETE_FLAG")
	public Boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
