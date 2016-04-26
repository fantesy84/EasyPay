/**
 * Project commons-dao
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.jdbc.support;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * TypeName: JdbcWriteDaoSupportImpl
 * 
 * <P>CreateTime: 2016年4月13日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public class JdbcWriteDaoSupportImpl extends NamedParameterJdbcDaoSupport implements JdbcWriteDaoSupport {
	
	public void setWriteDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
