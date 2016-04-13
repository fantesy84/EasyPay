/**
 * Project commons-dao
 * CreateTime: 2016年4月13日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.sys.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.fantesy84.exception.EasypayException;

/**
 * TypeName: JdbcReadOnlyDAO
 * 
 * <P>CreateTime: 2016年4月13日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public interface JdbcReadOnlyDAO {
	/**
	 * select by primary key
	 * @param namedParameterSql sql which use ':key' named parameter. <p>For example: <code>select u.USER_NAME as userName,u.USER_PASSWD as userPasswd from T_USER u where u.ID=:pk</code>
	 * @param valueType class of POJO
	 * @param pk primary key
	 * @return persist object
	 * @throws EasypayException
	 */
	<V extends Serializable, PK extends Serializable> V selectUniqueResult(String namedParameterSql, Class<V> valueType, PK pk) throws EasypayException;
	/**
	 * select collection result by named parameters
	 * @param namedParameterSql sql which use ':key' named parameter. <p>For example: <code>select u.USER_NAME as userName,u.USER_PASSWD as userPasswd from T_USER u where u.USER_NAME=:name</code>
	 * @param paramMap namedParametersValueMap. <p><i>Key is named parameter. <p><i>Value is parameter's value
	 * @param valueType class of POJO
	 * @return persist object collection
	 * @throws EasypayException
	 */
	<V> List<V> selectForList(String namedParameterSql, Map<String, Object> paramMap, Class<V> valueType) throws EasypayException;
	/**
	 * select special type result by named parameters
	 * <p> usually used by select count(*)
	 * @param namedParameterSql sql which use ':key' named parameter. <p>For example: <code>select count(*) from T_USER u where u.USER_NAME=:name</code>
	 * @param paramMap namedParametersValueMap. <p><i>Key is named parameter. <p><i>Value is parameter's value
	 * @param valueType class of POJO
	 * @return query result
	 * @throws EasypayException
	 */
	<V> V selectForObject(String namedParameterSql, Map<String, Object> paramMap, Class<V> valueType) throws EasypayException;
	/**
	 * select <code>List&lt;Map&lt;String, Object&gt;&gt;</code> by named parameters.
	 * <p> Usually used by query data for export to excel file  
	 * @param namedParameterSql <p>For example: <code>select u.USER_NAME as userName,u.USER_PASSWD as userPasswd from T_USER u where u.USER_NAME=:name</code>
	 * @param paramMap namedParametersValueMap. <p><i>Key is named parameter. <p><i>Value is parameter's value
	 * @return collection of persist rows. Each element of Map, <i>Key is column's lable(if not use 'as' special lable, will return column name) <i>Value is store object
	 * @throws EasypayException
	 */
	List<Map<String, Object>> selectForMap(String namedParameterSql, Map<String, Object> paramMap) throws EasypayException;
	
	<V> List<V> selectForListByParameterObject(String namedParameterSql, Object obj, Class<V> eleType) throws EasypayException;
}
