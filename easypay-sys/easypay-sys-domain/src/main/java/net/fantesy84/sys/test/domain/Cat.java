/**
 * Project: easypay-sys-domain
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author 葛俊杰
 *
 */
@Entity
@Table(name="CAT")
@PrimaryKeyJoinColumn(name="ANIMAL_ID")
public class Cat extends Animal {
	private static final long serialVersionUID = 7920166758986430764L;
	@Column(name="CAT_NAME",length=80)
	private String catName;
	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}
	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
}
