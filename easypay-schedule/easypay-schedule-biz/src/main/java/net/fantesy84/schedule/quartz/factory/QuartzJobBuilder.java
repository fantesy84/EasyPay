/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月4日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.quartz.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.util.jackson.JsonUtils;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
@Component("quartzJobFactory")
public class QuartzJobBuilder extends AbstractJobDetailBuilder {
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobBuilder.class);

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.job.factory.JobFactory#buildJobs(java.lang.String)
	 */
	@Override
	public EpSysSchedulers buildWithJSON(String json) throws EasypayException {
		logger.info("Schedule job bean's json: {}", json);
		EpSysSchedulers jobBean = JsonUtils.getInstance().toBean(json, EpSysSchedulers.class);
		super.addJob(jobBean);
		return jobBean;
	}
	
}
