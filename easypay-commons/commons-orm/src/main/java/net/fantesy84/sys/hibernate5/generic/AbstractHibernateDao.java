/**
 * Project: commons-orm
 * Created: 2016年5月27日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.hibernate5.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;

/**
 * @author 葛俊杰
 *
 */
public class AbstractHibernateDao<E extends Serializable, PK extends Serializable> implements HibernateDao<E, PK> {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);
	@Autowired
	private HibernateTemplate template;
	
	protected Class<E> entityClass;
	
	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AbstractHibernateDao() {
		super();
		Class<? extends AbstractHibernateDao> clazz = getClass();
		Type t = clazz.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) t;
			Type[] types = pt.getActualTypeArguments();
			entityClass = (Class<E>) types[0];
		}
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#insert(java.io.Serializable)
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={EasypayException.class})
	@SuppressWarnings("unchecked")
	@Override
	public PK insert(E entity) throws EasypayException {
		return (PK) template.save(entity);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#remove(java.io.Serializable)
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={EasypayException.class})
	@Override
	public void remove(E entity) throws EasypayException {
		template.delete(entity);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#modify(java.io.Serializable)
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={EasypayException.class})
	@Override
	public void modify(E entity) throws EasypayException {
		template.update(entity);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#insertOrModify(java.io.Serializable)
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={EasypayException.class})
	@Override
	public void insertOrModify(E entity) throws EasypayException {
		template.saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#merge(java.io.Serializable)
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={EasypayException.class})
	@Override
	public E merge(E entity) throws EasypayException {
		return template.merge(entity);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#getByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public E getByPrimaryKey(PK pk) throws EasypayException {
		return template.get(entityClass, pk);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#loadByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public E loadByPrimaryKey(PK pk) throws EasypayException {
		return template.load(entityClass, pk);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() throws EasypayException {
		return (List<E>) template.findByCriteria(DetachedCriteria.forClass(entityClass));
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#findByHql(java.lang.String, java.util.Map)
	 */
	@Override
	public List<E> findByHql(String hql, Map<String, Object> paramMap) throws EasypayException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.hibernate5.generic.HibernateDao#pageByHql(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public Pagination<E> pageByHql(String hql, Map<String, Object> paramMap, int firstResult, int maxResults)
			throws EasypayException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
