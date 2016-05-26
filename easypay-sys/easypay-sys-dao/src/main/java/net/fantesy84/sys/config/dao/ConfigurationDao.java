/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.config.dao;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.config.domain.Configuration;

/**
 * @author 葛俊杰
 *
 */
public interface ConfigurationDao {
	Long insert(Configuration config) throws EasypayException;
	void remove(Configuration config) throws EasypayException;
	void modify(Configuration config) throws EasypayException;
	Configuration findById(Long id) throws EasypayException;
}
