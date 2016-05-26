/**
 * Project: easypay-sys-dao
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.animal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.hibernate5.support.HibernateReadDaoSupport;
import net.fantesy84.sys.hibernate5.support.HibernateWriteDaoSupport;
import net.fantesy84.sys.test.domain.Animal;

/**
 * @author 葛俊杰
 *
 */
@Repository
public class AnimalDaoImpl implements AnimalDao {
	@Autowired
	private HibernateWriteDaoSupport writeDaoSupport;
	@Autowired
	private HibernateReadDaoSupport readDaoSupport;
	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.AnimalDao#insert(net.fantesy84.sys.test.domain.Animal)
	 */
	@Override
	public Integer insert(Animal animal) throws EasypayException {
		return (Integer) writeDaoSupport.insert(animal);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.AnimalDao#remove(net.fantesy84.sys.test.domain.Animal)
	 */
	@Override
	public void remove(Animal animal) throws EasypayException {
		writeDaoSupport.remove(animal);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.AnimalDao#modify(net.fantesy84.sys.test.domain.Animal)
	 */
	@Override
	public void modify(Animal animal) throws EasypayException {
		writeDaoSupport.modify(animal);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.AnimalDao#findById(java.lang.Integer)
	 */
	@Override
	public Animal findById(Integer id) throws EasypayException {
		// TODO Auto-generated method stub
		return readDaoSupport.selectByPrimaryKey(id, Animal.class);
	}

}
