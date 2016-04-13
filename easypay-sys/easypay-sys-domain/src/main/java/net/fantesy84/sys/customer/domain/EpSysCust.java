package net.fantesy84.sys.customer.domain;
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
 * EpSysCust generated by hbm2java
 */
@Entity
@Table(name = "EP_SYS_CUST", catalog = "EASY_PAY")
public class EpSysCust implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -699725584718637120L;
	private Integer autoId;
	private String custName;
	private boolean isCorpCust;
	private Set<EpSysUser> epSysUsers = new HashSet<EpSysUser>(0);

	public EpSysCust() {
	}

	public EpSysCust(String custName, boolean isCorpCust) {
		this.custName = custName;
		this.isCorpCust = isCorpCust;
	}

	public EpSysCust(String custName, boolean isCorpCust, Set<EpSysUser> epSysUsers) {
		this.custName = custName;
		this.isCorpCust = isCorpCust;
		this.epSysUsers = epSysUsers;
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

	@Column(name = "CUST_NAME", nullable = false, length = 40)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "IS_CORP_CUST", nullable = false)
	public boolean isIsCorpCust() {
		return this.isCorpCust;
	}

	public void setIsCorpCust(boolean isCorpCust) {
		this.isCorpCust = isCorpCust;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysCust")
	public Set<EpSysUser> getEpSysUsers() {
		return this.epSysUsers;
	}

	public void setEpSysUsers(Set<EpSysUser> epSysUsers) {
		this.epSysUsers = epSysUsers;
	}

}
