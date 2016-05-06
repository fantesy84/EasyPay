/**
 * Project easypay-schedule-web
 * CreateTime: 2016年4月29日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.quartz.job;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import net.fantesy84.easypay.job.domain.JobConfigBean;
import net.fantesy84.quartz.domain.job.JobAction;
import net.fantesy84.util.jackson.JsonUtils;

/**
 * TypeName: QuartzJobFactory
 * 
 * <P>CreateTime: 2016年4月29日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@DisallowConcurrentExecution
public abstract class AbstractQuartzJob implements Job {
	private static final Logger logger = LoggerFactory.getLogger(AbstractQuartzJob.class);
	public static final String DEFAULT_JOB_KEY = "easypay-schedule";
	@Autowired
	private JmsTemplate jmsTemplate;
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务开始运行!");
		JobConfigBean jobDetails = (JobConfigBean) context.getMergedJobDataMap().get(DEFAULT_JOB_KEY);
		final JobAction action = createJobAction(context);
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JsonUtils.getInstance().toJson(action));
			}
		});
		logger.info("任务名称={}", jobDetails.getJobName());
	}
	
	protected abstract JobAction createJobAction(JobExecutionContext context) throws JobExecutionException;
	
}
