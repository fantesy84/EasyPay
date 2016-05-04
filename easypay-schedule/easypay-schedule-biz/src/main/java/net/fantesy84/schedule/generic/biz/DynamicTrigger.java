/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月3日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.generic.biz;

import java.util.Date;

import net.fantesy84.exception.EasypayException;

/**
 * Description:
 * <P>在一个调度中,可能包含多个任务,一个任务可能包含多个触发器.所以我们采用操作最小粒度的触发器来进行管理.
 * @author 葛俊杰
 *
 */
public interface DynamicTrigger {
	/**
	 * 根据指定的触发器名称,cron表达式创建触发器并更新调度程序
	 * @param cronExpression cron表达式
	 * @see DynamicTrigger#schedule(String, String)
	 * @throws EasypayException
	 */
	public void schedule(String cronExpression) throws EasypayException;
	/**
	 * 根据指定的触发器名称,cron表达式创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param cronExpression cron表达式
	 * @see DynamicTrigger#schedule(String, String, String)
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, String cronExpression) throws EasypayException;
	/**
	 * 根据指定的触发器名称,触发器组名称,cron表达式创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @param cronExpression cron表达式
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, String triggerGroup, String cronExpression) throws EasypayException;
	
	/**
	 * 根据指定的开始时间创建触发器并更新调度程序
	 * @param fireTime 触发时间
	 * @see DynamicTrigger#schedule(String, Date)
	 * @throws EasypayException
	 */
	public void schedule(Date fireTime) throws EasypayException;
	/**
	 * 根据指定的触发器名称,开始时间创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param fireTime 触发时间
	 * @see DynamicTrigger#schedule(String, String, Date)
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, Date fireTime) throws EasypayException;
	/**
	 * 根据指定的触发器名称,触发器组名称,开始时间创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @param fireTime 触发时间
	 * @see DynamicTrigger#schedule(String, String, Date, Date)
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, String triggerGroup, Date fireTime) throws EasypayException;
	/**
	 * 根据指定的触发器名称,触发器组名称,开始时间和结束时间创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @param fireTime 触发时间
	 * @param endTime 结束时间
	 * @see DynamicTrigger#schedule(String, String, Date, Date, Integer, Long)
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, String triggerGroup, Date fireTime, Date endTime) throws EasypayException;
	/**
	 * 根据指定的触发器名称,触发器组名称,开始时间,结束时间,重复间隔和重复次数创建触发器并更新调度程序
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @param fireTime 触发时间
	 * @param endTime 结束时间
	 * @param repeat 重复次数
	 * @param repeatInterval 重复间隔(毫秒)
	 * @throws EasypayException
	 */
	public void schedule(String triggerName, String triggerGroup, Date fireTime, Date endTime, Integer repeat, Long repeatInterval) throws EasypayException;
	
	/**
	 * 暂停正在执行的触发器
	 * @param triggerName 触发器名称
	 * @see DynamicTrigger#pause(String, String)
	 * @throws EasypayException
	 */
	public void pause(String triggerName) throws EasypayException;
	/**
	 * 暂停正在执行的触发器
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @throws EasypayException
	 */
	public void pause(String triggerName, String triggerGroup) throws EasypayException;
	
	/**
	 * 恢复暂停的触发器
	 * @param triggerName 触发器名称
	 * @see DynamicTrigger#resume(String, String)
	 * @throws EasypayException
	 */
	public void resume(String triggerName) throws EasypayException;
	/**
	 * 恢复暂停的触发器
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @throws EasypayException
	 */
	public void resume(String triggerName, String triggerGroup) throws EasypayException;
	
}
