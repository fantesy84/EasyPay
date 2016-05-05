/**
 * Project: easypay-schedule-web
 * Created: 2016年4月29日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.quartz.loader;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public enum TriggerTypes {
	/**
	 * Trigger type: simple
	 */
	TRG_000("simple"),
	/**
	 * Trigger type: simple_properties
	 */
	TRG_001("simple_properties"),
	/**
	 * Trigger type: cron
	 */
	TRG_002("cron"),
	/**
	 * Trigger type: blob
	 */
	TRG_003("blob");
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
