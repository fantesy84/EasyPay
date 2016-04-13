/**
 * Project commons-hibernate
 * File: CommonReadOnlyDAO.java
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.common.dao;

import java.io.Serializable;

/**
 * TypeName: CommonReadOnlyDAO
 * 
 * <P>CreateTime: 2016年4月13日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public interface CommonReadOnlyDAO<T extends Serializable, PK extends Serializable> extends CommonDAO<T, PK>{

}
