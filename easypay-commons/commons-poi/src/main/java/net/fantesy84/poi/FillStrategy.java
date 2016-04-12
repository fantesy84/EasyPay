/**
 * Project net.fantesy84.poi
 * File: FillStrategy.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi;

import org.apache.poi.ss.usermodel.Cell;

/**
 * TypeName: FillStrategy
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public interface FillStrategy {
	<T> void fill(Cell cell, String headName, Class<T> javaType, Object original) throws Exception;
}
