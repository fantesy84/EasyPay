/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月3日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.quartz.biz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.utils.Key;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.schedule.generic.biz.DynamicTrigger;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public class QuartzDynamicTrigger implements DynamicTrigger {

	private Scheduler scheduler;

	private JobDetail jobDetail;

	/**
	 * @param scheduler
	 *            the scheduler to set
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	/**
	 * @param jobDetail
	 *            the jobDetail to set
	 */
	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String)
	 */
	@Override
	public void schedule(String cornExpression) throws EasypayException {
		schedule(null, cornExpression);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void schedule(String triggerName, String cornExpression) throws EasypayException {
		schedule(triggerName, null, cornExpression);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, String cornExpression) throws EasypayException {
		try {
			CronExpression cronExpression = new CronExpression(cornExpression);
			TriggerKey triggerKey = null;
			if (triggerName == null || triggerName.trim().length() == 0) {
				triggerName = Key.createUniqueName(triggerGroup);
			}
			triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
			Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup)
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
			if (scheduler.checkExists(triggerKey)) {
				scheduler.rescheduleJob(triggerKey, newTrigger);
			} else {
				scheduler.scheduleJob(jobDetail, newTrigger);
			}
		} catch (ParseException e) {
			throw new EasypayException(e);
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.util.
	 * Date)
	 */
	@Override
	public void schedule(Date fireTime) throws EasypayException {
		schedule(null, fireTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, Date fireTime) throws EasypayException {
		schedule(triggerName, null, fireTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, Date fireTime) throws EasypayException {
		schedule(triggerName, triggerGroup, 0L, fireTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.Long, java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, Long timeout, Date fireTime) throws EasypayException {
		schedule(triggerName, triggerGroup, timeout, 0, fireTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.Long, java.lang.Integer,
	 * java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, Long timeout, Integer repeat, Date fireTime)
			throws EasypayException {
		schedule(triggerName, triggerGroup, timeout, repeat, 0L, fireTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.Long, java.lang.Integer,
	 * java.lang.Long, java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, Long timeout, Integer repeat, Long repeatInterval,
			Date fireTime) throws EasypayException {
		// TODO Auto-generated method stub
		TriggerKey triggerKey = null;
		if (triggerName == null || triggerName.trim().length() == 0) {
			triggerName = Key.createUniqueName(triggerGroup);
		}
		triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.generic.biz.DynamicScheduler#pause(java.lang.
	 * String)
	 */
	@Override
	public void pause(String triggerName) throws EasypayException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.generic.biz.DynamicScheduler#pause(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void pause(String triggerName, String triggerGroup) throws EasypayException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#resume(java.lang.
	 * String)
	 */
	@Override
	public void resume(String triggerName) throws EasypayException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#resume(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void resume(String triggerName, String triggerGroup) throws EasypayException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#remove(java.lang.
	 * String)
	 */
	@Override
	public void remove(String triggerName) throws EasypayException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#remove(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void remove(String triggerName, String triggerGroup) throws EasypayException {
		// TODO Auto-generated method stub

	}

}
