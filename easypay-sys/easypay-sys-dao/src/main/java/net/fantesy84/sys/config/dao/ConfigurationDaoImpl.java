/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.config.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.config.domain.Configuration;
import net.fantesy84.sys.config.domain.TransformConfiguration;
import net.fantesy84.sys.hibernate5.support.HibernateReadDaoSupport;
import net.fantesy84.sys.hibernate5.support.HibernateWriteDaoSupport;

/**
 * @author 葛俊杰
 *
 */
@Repository
public class ConfigurationDaoImpl implements ConfigurationDao {
	@Autowired
	private HibernateWriteDaoSupport writeDaoSupport;
	@Autowired
	private HibernateReadDaoSupport readDaoSupport;

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.config.dao.ConfigurationDAO#insert(net.fantesy84.sys.config.domain.Configuration)
	 */
	@Override
	public Long insert(Configuration config) throws EasypayException {
		return (Long) writeDaoSupport.insert(config);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.config.dao.ConfigurationDAO#remove(net.fantesy84.sys.config.domain.Configuration)
	 */
	@Override
	public void remove(Configuration config) throws EasypayException {
		writeDaoSupport.remove(config);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.config.dao.ConfigurationDAO#modify(net.fantesy84.sys.config.domain.Configuration)
	 */
	@Override
	public void modify(Configuration config) throws EasypayException {
		writeDaoSupport.modify(config);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.config.dao.ConfigurationDAO#findById(java.lang.Long)
	 */
	@Override
	public Configuration findById(Long id) throws EasypayException {
		return readDaoSupport.selectByPrimaryKey(id, TransformConfiguration.class);
	}

}
