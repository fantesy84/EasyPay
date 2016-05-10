/**
 * Project: easypay-sys-domain
 * Created: 2016年5月10日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.user.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 葛俊杰
 *
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = -946167077810939391L;
	private Integer id;
	private String account;
	private String password;
	private Date created;
	private CustDTO cust;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the cust
	 */
	public CustDTO getCust() {
		return cust;
	}
	/**
	 * @param cust the cust to set
	 */
	public void setCust(CustDTO cust) {
		this.cust = cust;
	}
	
}
