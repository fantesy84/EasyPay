/**
 * Project: easypay-sys-dao
 * Created: 2016年5月10日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.test.sys.user.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.user.dao.UserDAO;
import net.fantesy84.sys.user.domain.UserDTO;
import net.fantesy84.util.jackson.JsonUtils;

/**
 * @author 葛俊杰
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
@Transactional
public class UserDAOTest {
	@Autowired
	private UserDAO dao;
	
	@Test
	public void test1() throws EasypayException{
		List<UserDTO> list = dao.findByUsernameAndPasswd("Washington", "6d69689d0056a27bce65398abc70297a");
		System.out.println(JsonUtils.getInstance().toJson(list));
	}
}
