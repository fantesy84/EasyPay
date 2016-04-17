package net.fantesy84.sys.hibernate5.support;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;

public interface HibernateReadDaoSupport {
	<T> T selectByPrimaryKey(Serializable pk, Class<T> entityClass) throws EasypayException;
	<T> T selectByPrimaryKey(Serializable pk, Class<T> entityClass, LockMode lockMode) throws EasypayException;
	<T> T loadByPrimaryKey(Serializable pk, Class<T> entityClass) throws EasypayException;
	<T> T loadByPrimaryKey(Serializable pk, Class<T> entityClass, LockMode lockMode) throws EasypayException;
	<T> List<T> selectByHQL(String namedParametersHQL, Map<String, ?> paramMap, Class<T> resultType) throws EasypayException;
	<T> List<T> selectByExample(T paramBean) throws EasypayException;
	<T> List<T> selectByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass) throws EasypayException;
	<T> List<T> selectByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass, int firstResult, int maxResults) throws EasypayException;
	Integer countByHQL(String namedParametersHQL, Map<String, ?> paramMap) throws EasypayException;
	<T> Integer countByExample(T paramBean) throws EasypayException;
	Integer countByDetachedCriteria(DetachedCriteria dc) throws EasypayException;
	<T> Pagination<T> paginationByHQL(String namedParametersHQL, Class<T> resultType, Map<String, ?> paramMap, int firstResult, int maxResults) throws EasypayException;
	<T> Pagination<T> paginationByExample(T paramBean, int firstResult, int maxResults) throws EasypayException;
	<T> Pagination<T> paginationByDetachedCriteria(DetachedCriteria dc, Class<T> entityClass, int firstResult, int maxResults) throws EasypayException;
}
