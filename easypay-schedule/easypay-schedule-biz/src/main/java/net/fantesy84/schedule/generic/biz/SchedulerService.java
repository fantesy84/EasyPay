/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月4日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.generic.biz;

import java.util.Map;

import net.fantesy84.easypay.job.domain.JobConfigBean;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.schedule.quartz.job.AbstractQuartzJob;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public interface SchedulerService {
	void Schedule(JobConfigBean configBean, Class<? extends AbstractQuartzJob> jobClass) throws EasypayException;
	void Schedule(Map<JobConfigBean, Class<? extends AbstractQuartzJob>> map) throws EasypayException;
	void pause(JobConfigBean configBean) throws EasypayException;
	void resume(JobConfigBean configBean) throws EasypayException;
	void remove(JobConfigBean configBean) throws EasypayException;
}
