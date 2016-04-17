/**
 * Project commons-dao
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.jdbc.support;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.fantesy84.util.reflect.ReflectUtils;

/**
 * TypeName: DefaultRowMapper
 * 
 * <P>
 * CreateTime: 2016年4月13日
 * <P>
 * UpdateTime:
 * 
 * @author junjie.ge
 * @param <T>
 *
 */
public class DefaultUniquePOJORowMapper<T> implements RowMapper<T> {
	private Class<T> valueType;

	/**
	 * @param valueType
	 */
	public DefaultUniquePOJORowMapper(Class<T> valueType) {
		super();
		this.valueType = valueType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		T entity = null;
		try {
			entity = valueType.getConstructor(new Class<?>[] {}).newInstance(new Object[] {});
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				Object obj = rs.getObject(i);
				String columnName = metaData.getColumnLabel(i + 1);
				Object javaValue = ReflectUtils.searchField(entity, columnName).getType().cast(obj);
				ReflectUtils.setter(entity, columnName, javaValue);
			}
		} catch (Exception e) {
			throw new SQLException(e);
		}
		return entity;
	}

}
