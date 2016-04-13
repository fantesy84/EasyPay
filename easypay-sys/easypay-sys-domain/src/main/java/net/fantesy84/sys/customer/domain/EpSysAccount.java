package net.fantesy84.sys.customer.domain;
// Generated 2016-4-13 22:00:27 by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.fantesy84.sys.bank.domain.EpSysBankOrder;
import net.fantesy84.sys.bill.domain.EpSysBill;
import net.fantesy84.sys.solution.domain.RpSysAcctSltRels;

/**
 * EpSysAccount generated by hbm2java
 */
@Entity
@Table(name = "EP_SYS_ACCOUNT", catalog = "EASY_PAY")
public class EpSysAccount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665590337697983317L;
	private Integer autoId;
	private EpSysUser epSysUser;
	private int acctNum;
	private String acctType;
	private BigDecimal acctBalance;
	private Boolean deleteFlag;
	private Set<RpSysAcctSltRels> rpSysAcctSltRelses = new HashSet<RpSysAcctSltRels>(0);
	private Set<EpSysBankOrder> epSysBankOrders = new HashSet<EpSysBankOrder>(0);
	private Set<EpSysBill> epSysBills = new HashSet<EpSysBill>(0);

	public EpSysAccount() {
	}

	public EpSysAccount(EpSysUser epSysUser, int acctNum, String acctType, BigDecimal acctBalance) {
		this.epSysUser = epSysUser;
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.acctBalance = acctBalance;
	}

	public EpSysAccount(EpSysUser epSysUser, int acctNum, String acctType, BigDecimal acctBalance, Boolean deleteFlag,
			Set<RpSysAcctSltRels> rpSysAcctSltRelses, Set<EpSysBankOrder> epSysBankOrders, Set<EpSysBill> epSysBills) {
		this.epSysUser = epSysUser;
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.acctBalance = acctBalance;
		this.deleteFlag = deleteFlag;
		this.rpSysAcctSltRelses = rpSysAcctSltRelses;
		this.epSysBankOrders = epSysBankOrders;
		this.epSysBills = epSysBills;
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
	@JoinColumn(name = "USER_ID", nullable = false)
	public EpSysUser getEpSysUser() {
		return this.epSysUser;
	}

	public void setEpSysUser(EpSysUser epSysUser) {
		this.epSysUser = epSysUser;
	}

	@Column(name = "ACCT_NUM", nullable = false)
	public int getAcctNum() {
		return this.acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	@Column(name = "ACCT_TYPE", nullable = false, length = 2)
	public String getAcctType() {
		return this.acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@Column(name = "ACCT_BALANCE", nullable = false, precision = 20)
	public BigDecimal getAcctBalance() {
		return this.acctBalance;
	}

	public void setAcctBalance(BigDecimal acctBalance) {
		this.acctBalance = acctBalance;
	}

	@Column(name = "DELETE_FLAG")
	public Boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysAccount")
	public Set<RpSysAcctSltRels> getRpSysAcctSltRelses() {
		return this.rpSysAcctSltRelses;
	}

	public void setRpSysAcctSltRelses(Set<RpSysAcctSltRels> rpSysAcctSltRelses) {
		this.rpSysAcctSltRelses = rpSysAcctSltRelses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysAccount")
	public Set<EpSysBankOrder> getEpSysBankOrders() {
		return this.epSysBankOrders;
	}

	public void setEpSysBankOrders(Set<EpSysBankOrder> epSysBankOrders) {
		this.epSysBankOrders = epSysBankOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysAccount")
	public Set<EpSysBill> getEpSysBills() {
		return this.epSysBills;
	}

	public void setEpSysBills(Set<EpSysBill> epSysBills) {
		this.epSysBills = epSysBills;
	}

}
