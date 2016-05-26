/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.animal.dao;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.test.domain.Animal;

/**
 * @author 葛俊杰
 *
 */
public interface AnimalDao {
	Integer insert(Animal animal) throws EasypayException;
	void remove(Animal animal) throws EasypayException;
	void modify(Animal animal) throws EasypayException;
	Animal findById(Integer id) throws EasypayException;
}
