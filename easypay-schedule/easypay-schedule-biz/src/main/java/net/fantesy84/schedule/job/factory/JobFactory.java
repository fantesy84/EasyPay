/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月4日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.job.factory;

import java.util.List;

import net.fantesy84.easypay.job.domain.EpSysSchedulers;
import net.fantesy84.exception.EasypayException;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public interface JobFactory {
	public List<EpSysSchedulers> getJobs() throws EasypayException;
}
