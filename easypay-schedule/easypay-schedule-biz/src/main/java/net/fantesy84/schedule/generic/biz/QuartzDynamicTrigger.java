/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月3日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.generic.biz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.utils.Key;

import net.fantesy84.exception.EasypayException;

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
	public void schedule(String cronExpression) throws EasypayException {
		schedule(null, cronExpression);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void schedule(String triggerName, String cronExpression) throws EasypayException {
		schedule(triggerName, null, cronExpression);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, String cronExpression) throws EasypayException {
		try {
			CronExpression expression = new CronExpression(cronExpression);
			TriggerKey triggerKey = null;
			if (triggerName == null || triggerName.trim().length() == 0) {
				triggerName = Key.createUniqueName(triggerGroup);
			}
			triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
			Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup)
					.withSchedule(CronScheduleBuilder.cronSchedule(expression)).build();
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
		schedule(triggerName, triggerGroup, fireTime, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.fantesy84.schedule.generic.biz.DynamicScheduler#schedule(java.lang.
	 * String, java.lang.String, java.lang.Long, java.util.Date)
	 */
	@Override
	public void schedule(String triggerName, String triggerGroup, Date fireTime, Date endTime) throws EasypayException {
		schedule(triggerName, triggerGroup, fireTime, endTime, 0, 0L);
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
	public void schedule(String triggerName, String triggerGroup, Date fireTime, Date endTime, Integer repeat, Long repeatInterval) throws EasypayException {
		TriggerKey triggerKey = null;
		if (triggerName == null || triggerName.trim().length() == 0) {
			triggerName = Key.createUniqueName(triggerGroup);
		}
		triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
		SimpleScheduleBuilder scheduleBuilder = null;
		if (repeat > 0) {
			if (repeatInterval != null && repeatInterval.longValue() > 0) {
				int intervalSeconds = (int) (repeatInterval/1000);
				scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(intervalSeconds);
			}
		}
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup);
		if (scheduleBuilder != null) {
			triggerBuilder.withSchedule(scheduleBuilder);
		}
		triggerBuilder.startAt(fireTime);
		if (endTime != null) {
			triggerBuilder.endAt(endTime);
		}
		Trigger newTrigger = triggerBuilder.build();
		try {
			if (scheduler.checkExists(triggerKey)) {
				scheduler.rescheduleJob(triggerKey, newTrigger);
			} else {
				scheduler.scheduleJob(jobDetail, newTrigger);
			}
		} catch (Exception e) {
			throw new EasypayException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.generic.biz.DynamicScheduler#pause(java.lang.
	 * String)
	 */
	@Override
	public void pause(String triggerName) throws EasypayException {
		pause(triggerName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.fantesy84.schedule.generic.biz.DynamicScheduler#pause(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void pause(String triggerName, String triggerGroup) throws EasypayException {
		try {
			scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
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
		resume(triggerName, null);
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
		try {
			scheduler.resumeTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
	}

}
