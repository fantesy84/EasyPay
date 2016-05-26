/**
 * Project: commons-orm
 * Created: 2016年5月26日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.hibernate5.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;

/**
 * 通用泛型DAO,自动判定实体类型,包含基本的增删改查方法.
 * <p>若需要其他方法,继承该接口可自定义方法
 * @author 葛俊杰
 *
 */
public interface HibernateDao<E extends Serializable, PK extends Serializable> {
	PK insert(E entity) throws EasypayException;
	void remove(E entity) throws EasypayException;
	void modify(E entity) throws EasypayException;
	void insertOrModify(E entity) throws EasypayException;
	E merge(E entity) throws EasypayException;
	E getByPrimaryKey(PK pk) throws EasypayException;
	E loadByPrimaryKey(PK pk) throws EasypayException;
	List<E> findAll() throws EasypayException;
	List<E> findByHql(String hql, Map<String, Object> paramMap) throws EasypayException;
	Pagination<E> pageByHql(String hql, Map<String, Object> paramMap, int firstResult, int maxResults) throws EasypayException;
}
