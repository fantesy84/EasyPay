/**
 * Project easypay-schedule-web
 * CreateTime: 2016年4月29日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.factory;

import net.fantesy84.exception.EasypayException;

/**
 * TypeName: EasypayScheduleJobLoader
 * 
 * <P>CreateTime: 2016年4月29日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public interface ScheduleJobLoader {
	public void reload() throws EasypayException;
}
