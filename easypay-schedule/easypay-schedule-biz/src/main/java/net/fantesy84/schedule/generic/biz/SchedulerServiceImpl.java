/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月6日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.generic.biz;

import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fantesy84.easypay.job.domain.JobConfigBean;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.schedule.quartz.job.AbstractQuartzJob;
import net.fantesy84.schedule.quartz.job.TriggerTypes;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {
	private static final Logger log = LoggerFactory.getLogger(SchedulerServiceImpl.class);
	private Scheduler scheduler;
	
	@Autowired
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.generic.biz.SchedulerService#Schedule(net.fantesy84.easypay.job.domain.JobConfigBean, java.lang.Class)
	 */
	@Override
	public void Schedule(JobConfigBean configBean, Class<? extends AbstractQuartzJob> jobClass)
			throws EasypayException {
		Trigger newTrigger = null;
		TriggerTypes type = Enum.valueOf(TriggerTypes.class, configBean.getTriggerType());
		log.info("Trigger type of config bean is [{}]", type.getType());
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
			.cronSchedule(configBean.getTriggerExpression());
			newTrigger = TriggerBuilder.newTrigger().withIdentity(configBean.getJobName(), configBean.getJobGroup())
					.withSchedule(cronScheduleBuilder).build();
			break;
		}
		TriggerKey key = TriggerKey.triggerKey(configBean.getTriggerName(), configBean.getTriggerGroup());
		try {
			if (!(scheduler.checkExists(key))) {
				JobDetail jobDetail = JobBuilder.newJob(jobClass)
						.withIdentity(configBean.getJobName(), configBean.getJobGroup()).build();
				jobDetail.getJobDataMap().put(AbstractQuartzJob.DEFAULT_JOB_KEY, configBean);
				scheduler.scheduleJob(jobDetail, newTrigger);
			} else {
				scheduler.rescheduleJob(key, newTrigger);
			}
		} catch (Exception e) {
			throw new EasypayException(e);
		}
		// TODO save configBean's detail to table: EP_SYS_SCHEDULERS
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.generic.biz.SchedulerService#Schedule(java.util.Map)
	 */
	@Override
	public void Schedule(Map<JobConfigBean, Class<? extends AbstractQuartzJob>> map) throws EasypayException {
		for (JobConfigBean config : map.keySet()) {
			Schedule(config, map.get(config));
		}
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.generic.biz.SchedulerService#pause(net.fantesy84.easypay.job.domain.JobConfigBean)
	 */
	@Override
	public void pause(JobConfigBean configBean) throws EasypayException {
		JobKey key = JobKey.jobKey(configBean.getJobName(), configBean.getJobGroup());
		try {
			if (scheduler.checkExists(key)) {
				scheduler.pauseJob(key);
			}
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.generic.biz.SchedulerService#resume(net.fantesy84.easypay.job.domain.JobConfigBean)
	 */
	@Override
	public void resume(JobConfigBean configBean) throws EasypayException {
		JobKey key = JobKey.jobKey(configBean.getJobName(), configBean.getJobGroup());
		try {
			if (scheduler.checkExists(key)) {
				scheduler.resumeJob(key);
			}
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.generic.biz.SchedulerService#remove(net.fantesy84.easypay.job.domain.JobConfigBean)
	 */
	@Override
	public void remove(JobConfigBean configBean) throws EasypayException {
		JobKey key = JobKey.jobKey(configBean.getJobName(), configBean.getJobGroup());
		try {
			if (scheduler.checkExists(key)) {
				scheduler.deleteJob(key);
			}
		} catch (SchedulerException e) {
			throw new EasypayException(e);
		}
	}

}
