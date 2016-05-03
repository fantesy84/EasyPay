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
	public void schedule(String cornExpression) throws EasypayException;
	public void schedule(String triggerName, String cornExpression) throws EasypayException;
	public void schedule(String triggerName, String triggerGroup, String cornExpression) throws EasypayException;
	
	public void schedule(Date fireTime) throws EasypayException;
	public void schedule(String triggerName, Date fireTime) throws EasypayException;
	public void schedule(String triggerName, String triggerGroup, Date fireTime) throws EasypayException;
	public void schedule(String triggerName, String triggerGroup, Long timeout, Date fireTime) throws EasypayException;
	public void schedule(String triggerName, String triggerGroup, Long timeout, Integer repeat, Date fireTime) throws EasypayException;
	public void schedule(String triggerName, String triggerGroup, Long timeout, Integer repeat, Long repeatInterval, Date fireTime) throws EasypayException;
	
	public void pause(String triggerName) throws EasypayException;
	/**
	 * 暂停正在执行的触发器
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @throws EasypayException
	 */
	public void pause(String triggerName, String triggerGroup) throws EasypayException;
	
	public void resume(String triggerName) throws EasypayException;
	/**
	 * 恢复暂停的触发器
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @throws EasypayException
	 */
	public void resume(String triggerName, String triggerGroup) throws EasypayException;
	
	public void remove(String triggerName) throws EasypayException;
	/**
	 * 移除触发器
	 * @param triggerName 触发器名称
	 * @param triggerGroup 触发器组名称
	 * @throws EasypayException
	 */
	public void remove(String triggerName, String triggerGroup) throws EasypayException;
}
