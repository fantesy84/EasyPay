package net.fantesy84.sys.hibernate5.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.util.CollectionUtil;
import net.fantesy84.util.ObjectUtil;

public class HibernateReadDaoSupportImpl implements HibernateReadDaoSupport {
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public <T> T selectByPrimaryKey(Serializable pk, Class<T> entityClass) throws EasypayException {
		return hibernateTemplate.get(entityClass, pk);
	}
	
	@Override
	public <T> T selectByPrimaryKey(Serializable pk, Class<T> entityClass, LockMode lockMode) throws EasypayException {
		return hibernateTemplate.get(entityClass, pk, lockMode);
	}
	
	@Override
	public <T> T loadByPrimaryKey(Serializable pk, Class<T> entityClass) throws EasypayException {
		return hibernateTemplate.load(entityClass, pk);
	}

	@Override
	public <T> T loadByPrimaryKey(Serializable pk, Class<T> entityClass, LockMode lockMode) throws EasypayException {
		return hibernateTemplate.load(entityClass, pk, lockMode);
	}

	@Override
	public <T> List<T> selectByHQL(String namedParametersHQL, Map<String, ?> paramMap, Class<T> resultType) throws EasypayException {
		return executeHql(namedParametersHQL, paramMap, resultType, 0, 0);
	}

	@Override
	public <T> List<T> selectByExample(T paramBean) throws EasypayException {
		return hibernateTemplate.findByExample(paramBean);
	}

	@Override
	public <T> List<T> selectByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass) throws EasypayException {
		List<?> list = hibernateTemplate.findByCriteria(dc);
		return CollectionUtil.convert(list, entityClass);
	}
	
	@Override
	public <T> List<T> selectByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass, int firstResult,
			int maxResults) throws EasypayException {
		List<?> list = hibernateTemplate.findByCriteria(dc, firstResult, maxResults);
		return CollectionUtil.convert(list, entityClass);
	}

	@Override
	public Integer countByHQL(String namedParametersHQL, Map<String, ?> paramMap) throws EasypayException {
		return executeHql(namedParametersHQL, paramMap, Integer.class, 0, 0);
	}

	@Override
	public <T> Integer countByExample(final T paramBean) throws EasypayException {
		return hibernateTemplate.executeWithNativeSession(new HibernateCallback<Long>(){

			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				Example example = Example.create(paramBean).ignoreCase().excludeNone();
				Criteria criteria = session.createCriteria(paramBean.getClass()).add(example);
				criteria.setProjection(Projections.rowCount());
				return (Long) criteria.uniqueResult();
			}
			
		}).intValue();
	}

	@Override
	public Integer countByDetachedCriteria(final DetachedCriteria dc) throws EasypayException {
		Integer result = ((Long) hibernateTemplate.executeWithNativeSession(new HibernateCallback<Object>(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria executableCriteria = dc.getExecutableCriteria(session);
				executableCriteria.setProjection(Projections.rowCount());
				return executableCriteria.uniqueResult();
			}
			
		})).intValue();
		return result;
	}

	@Override
	public <T extends Serializable> Pagination<T> paginationByHQL(String namedParametersHQL, Class<T> resultType, Map<String, ?> paramMap, int firstResult, int maxResults)
			throws EasypayException {
		return executeHql(namedParametersHQL, paramMap, resultType, firstResult, maxResults);
	}

	@Override
	public <T extends Serializable> Pagination<T> paginationByExample(T paramBean, int firstResult, int maxResults) throws EasypayException {
		if (maxResults <= 0) {
			throw new IllegalStateException("You don't need Pagination result! Please use method: selectByExample");
		}
		Pagination<T> page = new Pagination<>();
		List<T> rows = hibernateTemplate.findByExample(paramBean, firstResult, maxResults);
		page.setTotal(countByExample(paramBean));
		page.setIndex((firstResult/maxResults) + 1);
		page.setSize(new Integer(maxResults));
		page.setRows(rows);
		return page;
	}

	@Override
	public <T extends Serializable> Pagination<T> paginationByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass, int firstResult, int maxResults)
			throws EasypayException {
		if (maxResults <= 0) {
			throw new IllegalStateException("You don't need Pagination result! Please use method: selectByExample");
		}
		Pagination<T> page = new Pagination<>();
		List<T> rows = selectByDetachedCriteria(dc, entityClass, firstResult, maxResults);
		page.setTotal(countByDetachedCriteria(dc));
		page.setIndex((firstResult/maxResults) + 1);
		page.setSize(new Integer(maxResults));
		page.setRows(rows);
		return page;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	private <V, E> V executeHql(final String hql, final Map<String, ?> paramMap, final Class<E> resultClass, final int firstResult, final int maxResults) throws EasypayException {
		if (!(hql.startsWith("select") || hql.startsWith("SELECT") || hql.startsWith("from") || hql.startsWith("FROM"))) {
			throw new IllegalStateException("Please use write only dao support: HibernateWriteDaoSupport");
		}
		Object result = hibernateTemplate.execute(new HibernateCallback<Object>(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				if (paramMap != null && paramMap.size() > 0) {
					for (String key : paramMap.keySet()) {
						Object value = paramMap.get(key);
						if (ObjectUtil.isArray(value)) {
							Object[] objs = (Object[]) value;
							query.setParameterList(key, objs);
						} else if (value instanceof Collection<?>) {
							Collection<?> collection = (Collection<?>) value;
							query.setParameterList(key, collection);
						} else {
							query.setParameter(key, value);
						}
					}
				}
				if (maxResults > 0) {
					query.setFirstResult(firstResult);
					query.setMaxResults(maxResults);
				}
				Object result = null;
				if (hql.startsWith("select") || hql.startsWith("SELECT")) {
					if (resultClass != null) {
						if (resultClass == Integer.class || resultClass == int.class) {
							Long count = (Long) query.uniqueResult();
							result = count.intValue();
						} else {
							query.setResultTransformer(Transformers.aliasToBean(resultClass));
							result = query.list();
						}
					}
				}
				return result;
			}
			
		});
		return (V) result;
	}

}
