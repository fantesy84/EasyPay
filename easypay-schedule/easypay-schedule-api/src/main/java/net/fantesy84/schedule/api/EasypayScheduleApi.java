/**
 * Project: easypay-schedule-api
 * Created: 2016年5月5日
 * ©gopay.com Inc.
 */
package net.fantesy84.schedule.api;

import net.fantesy84.schedule.domain.RequestScheduleDTO;
import net.fantesy84.schedule.domain.ResponseScheduleDTO;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
public interface EasypayScheduleApi {
	public ResponseScheduleDTO schedule(RequestScheduleDTO request) throws Exception;
}
