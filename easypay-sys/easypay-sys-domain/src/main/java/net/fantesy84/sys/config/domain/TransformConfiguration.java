/**
 * Project: easypay-sys-domain
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.config.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 葛俊杰
 *
 */
@Entity
@Table(name = "EP_SYS_CONFIG_TRANS")
public class TransformConfiguration extends Configuration {
	private static final long serialVersionUID = 6028906911022061658L;
	@Column(name="TRANSFORM_CODE")
	private String transformCode;
	/**
	 * @return the transformCode
	 */
	public String getTransformCode() {
		return transformCode;
	}
	/**
	 * @param transformCode the transformCode to set
	 */
	public void setTransformCode(String transformCode) {
		this.transformCode = transformCode;
	}
	
}
