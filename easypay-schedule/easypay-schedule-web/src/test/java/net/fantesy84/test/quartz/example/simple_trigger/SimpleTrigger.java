/**
 * Project: easypay-schedule-web
 * Created: 2016年5月5日
 * ©gopay.com Inc.
 */
package net.fantesy84.test.quartz.example.simple_trigger;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public class SimpleTrigger {
	private static final Logger log = LoggerFactory.getLogger(SimpleTrigger.class);
	private void run() throws Exception {
		log.info("------- Initializing -------------------");
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-test.xml");
		Scheduler sched = (Scheduler) ac.getBean("scheduler");
		log.info("------- Initialization Complete --------");
		
		log.info("------- Scheduling Jobs ----------------");
		Date startTime = DateBuilder.dateOf(15, 0, 0, 5, 5);
		String jobGroupName = "job_group1";
		String triggerGroupName = "trigger_group1";
		JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity(JobKey.createUniqueName(jobGroupName), jobGroupName).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.createUniqueName(triggerGroupName), triggerGroupName).startAt(startTime).build();
		sched.scheduleJob(job, trigger);
		
		SchedulerMetaData metaData = sched.getMetaData();
	    log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
	}
	
	public static void main(String[] args) throws Exception {
		SimpleTrigger tc = new SimpleTrigger();
		tc.run();
	}
}
