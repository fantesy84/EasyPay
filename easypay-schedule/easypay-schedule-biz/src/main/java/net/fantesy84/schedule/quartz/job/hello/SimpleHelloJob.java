/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月16日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.schedule.quartz.job.hello;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 葛俊杰
 *
 */
public class SimpleHelloJob implements Job {

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		context.getMergedJobDataMap().get("easypay-schedule");
	}

}
