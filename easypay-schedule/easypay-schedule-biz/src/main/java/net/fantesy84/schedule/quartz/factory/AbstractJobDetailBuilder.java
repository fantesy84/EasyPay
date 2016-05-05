/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月4日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.quartz.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.exception.EasypayException;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public abstract class AbstractJobDetailBuilder implements JobDetailBuilder {
	private CopyOnWriteArrayList<EpSysSchedulers> jobs = new CopyOnWriteArrayList<>();
	
	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.job.factory.JobFactory#getJobs()
	 */
	@Override
	public List<EpSysSchedulers> getJobs() throws EasypayException {
		List<EpSysSchedulers> result = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			result.add(jobs.get(i));
		}
		return result;
	}

	protected void addJob(EpSysSchedulers job) {
		jobs.add(job);
	}
	
}
