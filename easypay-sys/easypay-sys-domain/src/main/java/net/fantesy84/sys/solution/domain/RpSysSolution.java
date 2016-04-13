package net.fantesy84.sys.solution.domain;
// Generated 2016-4-13 22:00:27 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RpSysSolution generated by hbm2java
 */
@Entity
@Table(name = "RP_SYS_SOLUTION", catalog = "EASY_PAY")
public class RpSysSolution implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2877072617546779054L;
	private Integer autoId;
	private String sltName;
	private String sltType;
	private String bizType;
	private boolean deleteFlag;
	private Set<EpSysSolutionBankFee> epSysSolutionBankFees = new HashSet<EpSysSolutionBankFee>(0);
	private Set<RpSysAcctSltRels> rpSysAcctSltRelses = new HashSet<RpSysAcctSltRels>(0);
	private Set<RpSysSolutionAcctGaings> rpSysSolutionAcctGaingses = new HashSet<RpSysSolutionAcctGaings>(0);

	public RpSysSolution() {
	}

	public RpSysSolution(String sltName, String sltType, String bizType, boolean deleteFlag) {
		this.sltName = sltName;
		this.sltType = sltType;
		this.bizType = bizType;
		this.deleteFlag = deleteFlag;
	}

	public RpSysSolution(String sltName, String sltType, String bizType, boolean deleteFlag,
			Set<EpSysSolutionBankFee> epSysSolutionBankFees, Set<RpSysAcctSltRels> rpSysAcctSltRelses,
			Set<RpSysSolutionAcctGaings> rpSysSolutionAcctGaingses) {
		this.sltName = sltName;
		this.sltType = sltType;
		this.bizType = bizType;
		this.deleteFlag = deleteFlag;
		this.epSysSolutionBankFees = epSysSolutionBankFees;
		this.rpSysAcctSltRelses = rpSysAcctSltRelses;
		this.rpSysSolutionAcctGaingses = rpSysSolutionAcctGaingses;
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

	@Column(name = "SLT_NAME", nullable = false, length = 20)
	public String getSltName() {
		return this.sltName;
	}

	public void setSltName(String sltName) {
		this.sltName = sltName;
	}

	@Column(name = "SLT_TYPE", nullable = false, length = 10)
	public String getSltType() {
		return this.sltType;
	}

	public void setSltType(String sltType) {
		this.sltType = sltType;
	}

	@Column(name = "BIZ_TYPE", nullable = false, length = 20)
	public String getBizType() {
		return this.bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	@Column(name = "DELETE_FLAG", nullable = false)
	public boolean isDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSysSolution")
	public Set<EpSysSolutionBankFee> getEpSysSolutionBankFees() {
		return this.epSysSolutionBankFees;
	}

	public void setEpSysSolutionBankFees(Set<EpSysSolutionBankFee> epSysSolutionBankFees) {
		this.epSysSolutionBankFees = epSysSolutionBankFees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSysSolution")
	public Set<RpSysAcctSltRels> getRpSysAcctSltRelses() {
		return this.rpSysAcctSltRelses;
	}

	public void setRpSysAcctSltRelses(Set<RpSysAcctSltRels> rpSysAcctSltRelses) {
		this.rpSysAcctSltRelses = rpSysAcctSltRelses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSysSolution")
	public Set<RpSysSolutionAcctGaings> getRpSysSolutionAcctGaingses() {
		return this.rpSysSolutionAcctGaingses;
	}

	public void setRpSysSolutionAcctGaingses(Set<RpSysSolutionAcctGaings> rpSysSolutionAcctGaingses) {
		this.rpSysSolutionAcctGaingses = rpSysSolutionAcctGaingses;
	}

}