/**
 * Project commons-poi
 * File: DefaultFillStrategyImpl.java
 * CreateTime: 2016年4月11日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import net.fantesy84.util.reflect.ReflectUtils;

/**
 * TypeName: DefaultFillStrategyImpl
 * <P>TODO
 * 
 * <P>CreateTime: 2016年4月11日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public class DefaultFillStrategyImpl implements FillStrategy {

	/* (non-Javadoc)
	 * @see net.fantesy84.poi.FillStrategy#fill(org.apache.poi.ss.usermodel.Cell, java.lang.String, java.lang.Class, java.lang.Object)
	 */
	@Override
	public <T> void fill(Cell cell, String headName, Class<T> javaType, Object original) throws Exception {
		String value = ReflectUtils.getter(original, headName, String.class);
		cell.setCellValue(new XSSFRichTextString(value));
	}

	

}
