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
	SIMPLE("TRG_000"), SIMPLE_PROPERTIES("TRG_001"), CRON("TRG_002"), BLOB("TRG_003");
	
	private String dictCode;

	/**
	 * @param dictCode
	 */
	private TriggerTypes(String dictCode) {
		this.dictCode = dictCode;
	}

	/**
	 * @return the dictCode
	 */
	public String getDictCode() {
		return dictCode;
	}
	
}
