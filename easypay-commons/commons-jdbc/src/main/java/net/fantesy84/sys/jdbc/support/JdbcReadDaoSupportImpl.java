/**
 * Project commons-dao
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.jdbc.support;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.fantesy84.exception.EasypayException;

/**
 * TypeName: JdbcDAO
 * 
 * <P>CreateTime: 2016年4月13日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@Repository("jdbcReadDaoSupport")
public class JdbcReadDaoSupportImpl extends NamedParameterJdbcDaoSupport implements JdbcReadDaoSupport {
	@Autowired
	public void setReadDataSource(@Qualifier("readDS01") DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.common.dao.JdbcReadOnlyDAO#selectUniqueResult(java.lang.String, java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <V extends Serializable, PK extends Serializable> V selectUniqueResult(String namedParameterSql, Class<V> valueType,
			PK pk) throws EasypayException {
		return super.getJdbcTemplate().queryForObject(namedParameterSql, new DefaultUniquePOJORowMapper<>(valueType), pk);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.common.dao.JdbcReadOnlyDAO#selectForList(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <V> List<V> selectForList(String namedParameterSql, Map<String, Object> paramMap, Class<V> valueType)
			throws EasypayException {
		return super.getNamedParameterJdbcTemplate().queryForObject(namedParameterSql, paramMap, new DefaultListRowMapper<>(valueType));
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.common.dao.JdbcReadOnlyDAO#selectForObject(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <V> V selectForObject(String namedParameterSql, Map<String, Object> paramMap, Class<V> valueType)
			throws EasypayException {
		return super.getNamedParameterJdbcTemplate().queryForObject(namedParameterSql, paramMap, valueType);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.common.dao.JdbcReadOnlyDAO#selectForMap(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> selectForMap(String namedParameterSql, Map<String, Object> paramMap)
			throws EasypayException {
		return super.getNamedParameterJdbcTemplate().queryForList(namedParameterSql, paramMap);
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.sys.common.dao.JdbcReadOnlyDAO#selectForListByParameterObject(java.lang.String, java.lang.Object, java.lang.Class)
	 */
	@Override
	public <V> List<V> selectForListByParameterObject(String namedParameterSql, Object obj, Class<V> eleType)
			throws EasypayException {
		MapSqlParameterSource map = new MapSqlParameterSource();
		Field[] fields = obj.getClass().getFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getModifiers() == Modifier.FINAL || fields[i].getModifiers() == Modifier.STATIC) {
				continue;
			}
			map.addValue(fields[i].getName(), obj);
		}
		return super.getNamedParameterJdbcTemplate().queryForList(namedParameterSql, map, eleType);
	}
	
}
