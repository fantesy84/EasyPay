/**
 * Project: easypay-schedule-web
 * Created: 2016年4月29日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.factory;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public enum TriggerTypes {
	TRG_000("simple"),TRG_001("simple_properties"),TRG_002("cron"),TRG_003("blob");
	private String type;

	/**
	 * @param type
	 */
	private TriggerTypes(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
}
