/**
 * Project commons-hibernate
 * File: CommonDAO.java
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.common.dao;

import java.io.Serializable;
import java.util.List;

import net.fantesy84.exception.EasypayException;

/**
 * TypeName: CommonDAO
 * 
 * <P>CreateTime: 2016年4月13日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public interface CommonDAO<T extends Serializable, PK extends Serializable> {
	List<T> queryWithSQL(String sqlString) throws EasypayException;
	List<T> queryWithHQL(String hqlString) throws EasypayException;
}
