package net.fantesy84.sys.hibernate5.support;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.LockMode;

import net.fantesy84.exception.EasypayException;

public interface HibernateWriteDaoSupport {
	Serializable insert(Object entity) throws EasypayException;
	void modify(Object entity) throws EasypayException;
	void modify(Object entity, LockMode mode) throws EasypayException;
	<T> T merge(T entity) throws EasypayException;
	void remove(Object entity) throws EasypayException;
	void remove(Object entity, LockMode mode) throws EasypayException;
	int executeCallback(String hql, Map<String, ?> paramMap) throws EasypayException;
}
