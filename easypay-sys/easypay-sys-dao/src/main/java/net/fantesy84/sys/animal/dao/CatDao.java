/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.animal.dao;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.test.domain.Cat;

/**
 * @author 葛俊杰
 *
 */
public interface CatDao {
	Integer insert(Cat cat) throws EasypayException;
	void remove(Cat cat) throws EasypayException;
	void modify(Cat cat) throws EasypayException;
	Cat findById(Integer id) throws EasypayException;
}
