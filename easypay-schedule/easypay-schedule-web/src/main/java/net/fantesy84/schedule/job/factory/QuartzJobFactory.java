/**
 * Project easypay-schedule-web
 * CreateTime: 2016年4月29日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.factory;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fantesy84.quartz.domain.EpQuartzJobDetails;

/**
 * TypeName: QuartzJobFactory
 * 
 * <P>CreateTime: 2016年4月29日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job {
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);
	public static final String DEFAULT_JOB_KEY = "easypay-schedule";
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务开始运行!");
		EpQuartzJobDetails jobDetails = (EpQuartzJobDetails) context.getMergedJobDataMap().get(DEFAULT_JOB_KEY);
		logger.info("任务名称={}", jobDetails.getId().getJobName());
	}

}
