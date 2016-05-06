/**
 * Project: easypay-schedule-domain
 * Created: 2016年5月6日
 * ©gopay.com Inc.
 */
package net.fantesy84.quartz.domain.job;

import java.io.Serializable;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public class Action implements Serializable {
	private static final long serialVersionUID = 671974246405582199L;
	private String productCode;
	private String jobCode;
	
	/**
	 * @param productCode
	 * @param jobCode
	 */
	public Action(String productCode, String jobCode) {
		super();
		this.productCode = productCode;
		this.jobCode = jobCode;
	}
	/**
	 * 
	 */
	public Action() {
		super();
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the jobCode
	 */
	public String getJobCode() {
		return jobCode;
	}
	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
}
