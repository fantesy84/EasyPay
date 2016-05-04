/**
 * Project: easypay-schedule-web
 * Created: 2016年4月29日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.factory;

import java.util.Iterator;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.exception.EasypayException;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public class EasypaySchedulerJobLoader implements ScheduleJobLoader {
	private static final Logger logger = LoggerFactory.getLogger(EasypaySchedulerJobLoader.class);
	private Scheduler scheduler;
	private JobFactory jobFactory;
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.job.factory.EasypayScheduleJobLoader#load()
	 */
	@Override
	public void reload() throws EasypayException {
		List<EpSysSchedulers> jobList = jobFactory.getJobs();
		if (jobList != null && jobList.size() > 0) {
			Iterator<EpSysSchedulers> iterator = jobList.iterator();
			while (iterator.hasNext()) {
				EpSysSchedulers job = iterator.next();
				// prepare an new Trigger for reload scheduler
				Trigger newTrigger = null;
				TriggerTypes type = Enum.valueOf(TriggerTypes.class, job.getTriggerType());
				switch (type) {
				case TRG_000:
					// Simple trigger
					break;
				case TRG_001:
					// Simple properties trigger
					break;
				case TRG_003:
					// Blob trigger
					break;

				default:
					// Use corn trigger default. As Enum TriggerTypes is TRG_002
					CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
							.cronSchedule(job.getTriggerExpression());
					newTrigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
							.withSchedule(cronScheduleBuilder).build();
					break;
				}
				TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());
				try {
					if (!(scheduler.checkExists(triggerKey))) {
						JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
								.withIdentity(job.getJobName(), job.getJobGroup()).build();
						jobDetail.getJobDataMap().put(QuartzJob.DEFAULT_JOB_KEY, job);
						scheduler.scheduleJob(jobDetail, newTrigger);
					} else {
						scheduler.rescheduleJob(triggerKey, newTrigger);
					}
				} catch (Exception e) {
					throw new EasypayException(e);
				}
			}
		} else {
			logger.warn("None job has been found in jobList");
		}
	}

	
	/**
	 * @param scheduler the scheduler to set
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	/**
	 * @param jobFactory the jobFactory to set
	 */
	public void setJobFactory(JobFactory jobFactory) {
		this.jobFactory = jobFactory;
	}

}
