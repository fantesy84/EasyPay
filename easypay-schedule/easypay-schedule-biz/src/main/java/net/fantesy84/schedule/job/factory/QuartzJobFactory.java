/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月4日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.job.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.exception.EasypayException;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
@Component("quartzJobFactory")
public class QuartzJobFactory extends AbstractJobFactory implements InitializingBean{
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);
	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.job.factory.AbstractJobFactory#buildJobs(java.lang.String)
	 */
	@Override
	public void buildJobs(String json) throws EasypayException {
		for (int i = 0; i < 5; i++) {
			logger.info("\n\nCreate JobBean - {}\n\n", i);
			EpSysSchedulers job = new EpSysSchedulers();
			job.setScheduleName("test");
			job.setJobName("TestCronJob" + i);
			job.setJobGroup("TestGroup");
			job.setTriggerName("CronTrigger_" + i);
			job.setTriggerGroup("TestTriggerGroup");
			job.setTriggerType("TRG_002");
			job.setTriggerExpression("0/3 * * * * ?");
			super.addJob(job);
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			buildJobs(null);
		} catch (EasypayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
