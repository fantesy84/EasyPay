/**
 * Project: easypay-sys-domain
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.test.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author 葛俊杰
 *
 */
@Entity
@Table(name="ANIMAL")
@Inheritance(strategy=InheritanceType.JOINED)
public class Animal implements Serializable{
	private static final long serialVersionUID = -5561463577343820923L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ANIMAL_ID",unique=true,nullable=false)
	private Integer id;
	@Column(name="TYPE",length=11)
	private String type;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
