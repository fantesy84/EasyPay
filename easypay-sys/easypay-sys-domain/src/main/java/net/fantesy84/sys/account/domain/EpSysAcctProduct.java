package net.fantesy84.sys.account.domain;
// Generated 2016-4-26 23:25:28 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EpSysAcctProduct generated by hbm2java
 */
@Entity
@Table(name = "EP_SYS_ACCT_PRODUCT", catalog = "EASY_PAY")
public class EpSysAcctProduct implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4559449601078597701L;
	private Integer autoId;
	private EpSysAcctProLine epSysAcctProLine;
	private String apName;
	private String apBiz;
	private Boolean deleteFlag;
	private Date createTime;
	private Date updateTime;
	private Set<EpSysAccount> epSysAccounts = new HashSet<EpSysAccount>(0);

	public EpSysAcctProduct() {
	}

	public EpSysAcctProduct(EpSysAcctProLine epSysAcctProLine, String apName, String apBiz, Date createTime,
			Date updateTime) {
		this.epSysAcctProLine = epSysAcctProLine;
		this.apName = apName;
		this.apBiz = apBiz;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public EpSysAcctProduct(EpSysAcctProLine epSysAcctProLine, String apName, String apBiz, Boolean deleteFlag,
			Date createTime, Date updateTime, Set<EpSysAccount> epSysAccounts) {
		this.epSysAcctProLine = epSysAcctProLine;
		this.apName = apName;
		this.apBiz = apBiz;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.epSysAccounts = epSysAccounts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AUTO_ID", unique = true, nullable = false)
	public Integer getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APL_ID", nullable = false)
	public EpSysAcctProLine getEpSysAcctProLine() {
		return this.epSysAcctProLine;
	}

	public void setEpSysAcctProLine(EpSysAcctProLine epSysAcctProLine) {
		this.epSysAcctProLine = epSysAcctProLine;
	}

	@Column(name = "AP_NAME", nullable = false, length = 80)
	public String getApName() {
		return this.apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	@Column(name = "AP_BIZ", nullable = false, length = 80)
	public String getApBiz() {
		return this.apBiz;
	}

	public void setApBiz(String apBiz) {
		this.apBiz = apBiz;
	}

	@Column(name = "DELETE_FLAG")
	public Boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	@Column(name = "UPDATE_TIME", nullable = false, length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysAcctProduct")
	public Set<EpSysAccount> getEpSysAccounts() {
		return this.epSysAccounts;
	}

	public void setEpSysAccounts(Set<EpSysAccount> epSysAccounts) {
		this.epSysAccounts = epSysAccounts;
	}

}
