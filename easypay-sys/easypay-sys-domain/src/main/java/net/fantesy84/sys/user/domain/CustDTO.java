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
public class CustDTO implements Serializable {
	private static final long serialVersionUID = -1813372251410245153L;
	private Integer id;
	private String custName;
	private String custType;
	private Date createTime;
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
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the custType
	 */
	public String getCustType() {
		return custType;
	}
	/**
	 * @param custType the custType to set
	 */
	public void setCustType(String custType) {
		this.custType = custType;
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
	
}
