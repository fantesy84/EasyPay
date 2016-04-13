package net.fantesy84.sys.solution.domain;
// Generated 2016-4-13 22:00:27 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.fantesy84.sys.customer.domain.EpSysAccount;

/**
 * RpSysAcctSltRels generated by hbm2java
 */
@Entity
@Table(name = "RP_SYS_ACCT_SLT_RELS", catalog = "EASY_PAY")
public class RpSysAcctSltRels implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2237604571554383417L;
	private RpSysAcctSltRelsId id;
	private EpSysAccount epSysAccount;
	private RpSysSolution rpSysSolution;
	private boolean deleteFlag;

	public RpSysAcctSltRels() {
	}

	public RpSysAcctSltRels(RpSysAcctSltRelsId id, EpSysAccount epSysAccount, RpSysSolution rpSysSolution,
			boolean deleteFlag) {
		this.id = id;
		this.epSysAccount = epSysAccount;
		this.rpSysSolution = rpSysSolution;
		this.deleteFlag = deleteFlag;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "sltId", column = @Column(name = "SLT_ID", nullable = false)),
			@AttributeOverride(name = "acctId", column = @Column(name = "ACCT_ID", nullable = false)) })
	public RpSysAcctSltRelsId getId() {
		return this.id;
	}

	public void setId(RpSysAcctSltRelsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCT_ID", nullable = false, insertable = false, updatable = false)
	public EpSysAccount getEpSysAccount() {
		return this.epSysAccount;
	}

	public void setEpSysAccount(EpSysAccount epSysAccount) {
		this.epSysAccount = epSysAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SLT_ID", nullable = false, insertable = false, updatable = false)
	public RpSysSolution getRpSysSolution() {
		return this.rpSysSolution;
	}

	public void setRpSysSolution(RpSysSolution rpSysSolution) {
		this.rpSysSolution = rpSysSolution;
	}

	@Column(name = "DELETE_FLAG", nullable = false)
	public boolean isDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}