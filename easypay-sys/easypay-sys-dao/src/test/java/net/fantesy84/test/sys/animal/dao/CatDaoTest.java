/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.test.sys.animal.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.animal.dao.CatDao;
import net.fantesy84.sys.test.domain.Cat;

/**
 * @author 葛俊杰
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
@Transactional
@Rollback(false)
public class CatDaoTest {
	@Autowired
	private CatDao dao;
	
	@Test
	public void testSave() throws EasypayException {
		Cat cat = new Cat();
		cat.setType("猫咪");
		cat.setCatName("凯蒂");
		dao.insert(cat);
	}
}
