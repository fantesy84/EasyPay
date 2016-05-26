/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.test.sys.config.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.config.dao.ConfigurationDao;
import net.fantesy84.sys.config.domain.Configuration;
import net.fantesy84.sys.config.domain.TransformConfiguration;
import net.fantesy84.util.jackson.JsonUtils;

/**
 * @author 葛俊杰
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
@Transactional
@Rollback(false)
public class ConfigurationDaoTest {
	@Autowired
	private ConfigurationDao dao;
	
	@Test
	public void testSave() throws EasypayException{
		TransformConfiguration config = new TransformConfiguration();
		config.setConfigName("交易基础设置");
		config.setConfigType("transform_base");
		config.setCreateTime(new Date());
		config.setUpdateTime(new Date());
		config.setIsActive(Boolean.TRUE);
		config.setDeleteFlag(Boolean.FALSE);
		config.setOptId(1l);
		config.setTransformCode("crossbroad");
		dao.insert(config);
	}
	
	@Test
	public void testUpdate() throws EasypayException {
		TransformConfiguration config = new TransformConfiguration();
		config.setConfigId(2l);
		config.setConfigName("交易基础设置");
		config.setConfigType("transform_base");
		config.setCreateTime(new Date());
		config.setUpdateTime(new Date());
		config.setIsActive(Boolean.FALSE);
		config.setDeleteFlag(Boolean.FALSE);
		config.setOptId(1l);
		config.setTransformCode("crossbroad");
		dao.modify(config);
	}
	
	@Test
	public void testFind() throws EasypayException {
		Configuration config = dao.findById(2l);
		String json = JsonUtils.getInstance().toJson(config);
		System.out.println(json);
	}
	
	@Test
	public void testRemove() throws EasypayException {
		Configuration config = dao.findById(2l);
		dao.remove(config);
	}
	
}
