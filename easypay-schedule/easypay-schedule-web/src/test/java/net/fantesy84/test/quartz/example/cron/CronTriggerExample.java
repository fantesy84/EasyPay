/**
 * Project: easypay-schedule-web
 * Created: 2016年5月5日
 * ©gopay.com Inc.
 */
package net.fantesy84.test.quartz.example.cron;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <P>
 * 
 * @author junjie.ge
 * @since JDK1.7
 */
public class CronTriggerExample {
	private static final Logger log = LoggerFactory.getLogger(CronTriggerExample.class);

	private void run() throws Exception {
		log.info("------- Initializing -------------------");
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-test.xml");
		Scheduler sched = (Scheduler) ac.getBean("scheduler");
		log.info("------- Initialization Complete --------");

		log.info("------- Scheduling Jobs ----------------");
		String jobGroupName = "job_group";
		String triggerGroupName = "cron_trigger_group";
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
				.withIdentity(JobKey.createUniqueName(jobGroupName), jobGroupName).build();
		ScheduleBuilder<CronTrigger> schedulrBuilder = CronScheduleBuilder
				.cronSchedule("0,15 * * ? * MON-FRI");
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(TriggerKey.createUniqueName(triggerGroupName), triggerGroupName).withSchedule(schedulrBuilder)
				.build();
		sched.scheduleJob(job, trigger);
	}

	public static void main(String[] args) throws Exception {
		CronTriggerExample tc = new CronTriggerExample();
		tc.run();
	}
}
