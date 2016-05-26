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
import net.fantesy84.sys.test.domain.Cat;

/**
 * @author 葛俊杰
 *
 */
@Repository
public class CatDaoImpl implements CatDao {
	@Autowired
	private HibernateWriteDaoSupport writeDaoSupport;
	@Autowired
	private HibernateReadDaoSupport readDaoSupport;
	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.CatDao#insert(net.fantesy84.sys.test.domain.Cat)
	 */
	@Override
	public Integer insert(Cat cat) throws EasypayException {
		return (Integer) writeDaoSupport.insert(cat);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.CatDao#remove(net.fantesy84.sys.test.domain.Cat)
	 */
	@Override
	public void remove(Cat cat) throws EasypayException {
		writeDaoSupport.remove(cat);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.CatDao#modify(net.fantesy84.sys.test.domain.Cat)
	 */
	@Override
	public void modify(Cat cat) throws EasypayException {
		writeDaoSupport.modify(cat);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.animal.dao.CatDao#findById(java.lang.Integer)
	 */
	@Override
	public Cat findById(Integer id) throws EasypayException {
		return readDaoSupport.selectByPrimaryKey(id, Cat.class);
	}

}
