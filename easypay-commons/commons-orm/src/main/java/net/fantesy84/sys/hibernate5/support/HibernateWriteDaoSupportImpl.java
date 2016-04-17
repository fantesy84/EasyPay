package net.fantesy84.sys.hibernate5.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.util.ObjectUtil;

public class HibernateWriteDaoSupportImpl implements HibernateWriteDaoSupport {

	private HibernateTemplate hibernateTemplate;

	@Override
	public Serializable insert(Object entity) throws EasypayException {
		return hibernateTemplate.save(entity);
	}

	@Override
	public void update(Object entity) throws EasypayException {
		hibernateTemplate.update(entity);
	}

	@Override
	public void update(Object entity, LockMode mode) throws EasypayException {
		hibernateTemplate.update(entity, mode);
	}

	@Override
	public <T> T merge(T entity) throws EasypayException {
		return hibernateTemplate.merge(entity);
	}

	@Override
	public void delete(Object entity) throws EasypayException {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void delete(Object entity, LockMode mode) throws EasypayException {
		hibernateTemplate.delete(entity, mode);		
	}

	@Override
	public int executeCallback(String hql, Map<String, ?> paramMap) throws EasypayException {
		return doExecute(hql, paramMap);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private int doExecute(final String hql, final Map<String, ?> paramMap) throws EasypayException {
		if (hql.startsWith("select") || hql.startsWith("SELECT") || hql.startsWith("from") || hql.startsWith("FROM")) {
			throw new IllegalStateException("Please use read only dao support: HibernateReadDaoSupport");
		}
		int result = hibernateTemplate.execute(new HibernateCallback<Integer>(){

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
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
				return (int)query.uniqueResult();
			}
			
		});
		return result;
	}
}
