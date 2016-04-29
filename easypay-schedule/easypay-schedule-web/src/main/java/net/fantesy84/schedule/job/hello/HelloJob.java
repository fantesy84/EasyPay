/**
 * Project easypay-schedule-web
 * CreateTime: 2016年4月29日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.hello;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import net.fantesy84.schedule.job.factory.EasypayJobExecutor;
import net.fantesy84.schedule.job.factory.QuartzJobFactory;

/**
 * TypeName: HelloJob
 * 
 * <P>CreateTime: 2016年4月29日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@Component("helloJob")
public class HelloJob implements EasypayJobExecutor{

	@Autowired
	private @Qualifier("schedulerFactoryBean")SchedulerFactoryBean schedulerFactoryBean;
	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.job.factory.EasypayJobExecutor#jobExecutor()
	 */
	@Override
	public void jobExecutor() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class).withIdentity("hello", "easypay").build();
		jobDetail.getJobDataMap().put("easypay-schedule", "hello");
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("hello", "easypay").withSchedule(cronScheduleBuilder).build();
		TriggerKey triggerKey = TriggerKey.triggerKey("hello", "easypay");
		scheduler.rescheduleJob(triggerKey, trigger);
	}
	
}
