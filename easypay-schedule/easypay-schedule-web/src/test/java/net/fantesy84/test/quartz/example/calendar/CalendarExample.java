/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package net.fantesy84.test.quartz.example.calendar;

import static org.quartz.JobBuilder.newJob;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.calendar.AnnualCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This example will demonstrate how calendars can be used to exclude periods of
 * time when scheduling should not take place.
 */
public class CalendarExample {

	public void run() throws Exception {
		final Logger log = LoggerFactory.getLogger(CalendarExample.class);

		log.info("------- Initializing ----------------------");

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-test.xml");
		Scheduler sched = (Scheduler) ac.getBean("scheduler");

		log.info("------- Initialization Complete -----------");

		log.info("------- Scheduling Jobs -------------------");

		// Add the holiday calendar to the schedule
		AnnualCalendar holidays = new AnnualCalendar();

		// fourth of July (July 4)
		Calendar myHoliday = new GregorianCalendar(2016, 5, 9);
		holidays.setDayExcluded(myHoliday, true);
		String calendarName = "HolidaysCalendar_" + UUID.randomUUID().toString().substring(0, 32);

		// tell the schedule about our holiday calendar
		sched.addCalendar(calendarName, holidays, false, false);

		String jobGroup = "calendar_test_job_group";
		String triggerGroup = "calendar_test_trigger_group";
		JobDetail job = newJob(SimpleJob.class).withIdentity(JobKey.createUniqueName(jobGroup), jobGroup).build();
		ScheduleBuilder<CronTrigger> cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * MON-FRI *");
		// SimpleTrigger trigger =
		// newTrigger().withIdentity(TriggerKey.createUniqueName(triggerGroup),
		// triggerGroup).startAt(runDate)
		// .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).modifiedByCalendar(calendarName).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.createUniqueName(triggerGroup), triggerGroup)
				.withSchedule(cronScheduleBuilder).modifiedByCalendar(calendarName).build();
		sched.scheduleJob(job, trigger);
		log.info("------- Starting Scheduler ----------------");
		sched.start();

		log.info("------- Waiting 60 seconds... --------------");
		try {
			// wait 30 seconds to show jobs
			Thread.sleep(60L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}

		// shut down the scheduler
		log.info("------- Shutting Down ---------------------");
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");

		SchedulerMetaData metaData = sched.getMetaData();
		log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

	}

	public static void main(String[] args) throws Exception {

		CalendarExample example = new CalendarExample();
		example.run();
	}

}
