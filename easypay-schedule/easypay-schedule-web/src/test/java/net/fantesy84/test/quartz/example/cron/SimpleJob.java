/**
 * Project: easypay-schedule-web
 * Created: 2016年5月5日
 * ©gopay.com Inc.
 */
package net.fantesy84.test.quartz.example.cron;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public class SimpleJob implements Job {
	private static final Logger logger = LoggerFactory.getLogger(SimpleJob.class);
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();
		logger.info("SimpleJob says: {} executing at {}", key, new Date());
	}

}
