/**
 * Project: easypay-schedule-web
 * Created: 2016年4月29日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.job.init;

import java.util.Collection;
import java.util.Iterator;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.schedule.job.factory.EasypayScheduleJobLoader;
import net.fantesy84.schedule.job.factory.QuartzJobFactory;
import net.fantesy84.schedule.job.factory.TriggerTypes;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public class EasypaySchedulerJobLoaderImpl implements EasypayScheduleJobLoader {
	private static final Logger logger = LoggerFactory.getLogger(EasypaySchedulerJobLoaderImpl.class);
	private SchedulerFactoryBean schedulerFactoryBean;
	private Collection<EpSysSchedulers> jobList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.job.factory.EasypayScheduleJobLoader#load()
	 */
	@Override
	public void reload() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		if (jobList != null && jobList.size() > 0) {
			Iterator<EpSysSchedulers> iterator = jobList.iterator();
			while (iterator.hasNext()) {
				EpSysSchedulers job = iterator.next();
				TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());
				Trigger trigger = scheduler.getTrigger(triggerKey);
				if (trigger == null) {
					JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
							.withIdentity(job.getJobName(), job.getJobGroup()).build();
					jobDetail.getJobDataMap().put(QuartzJobFactory.DEFAULT_JOB_KEY, job);
					String triggerType = job.getTriggerType();
					TriggerTypes type = TriggerTypes.SIMPLE;
					switch (type) {
					case SIMPLE:
						
						break;

					default:
						break;
					}
				} else {

				}
			}
		} else {
			logger.warn("None job has been found in jobList");
		}
	}

	/**
	 * @param schedulerFactoryBean
	 *            the schedulerFactoryBean to set
	 */
	public void setSchedulerFactoryBean(SchedulerFactoryBean schedulerFactoryBean) {
		this.schedulerFactoryBean = schedulerFactoryBean;
	}

	/**
	 * @return the jobList
	 */
	public Collection<EpSysSchedulers> getJobList() {
		return jobList;
	}

	/**
	 * @param jobList
	 *            the jobList to set
	 */
	public void setJobList(Collection<EpSysSchedulers> jobList) {
		this.jobList = jobList;
	}

}
