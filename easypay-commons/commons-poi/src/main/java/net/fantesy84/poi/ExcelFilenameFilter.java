/**
 * Project commons-poi
 * File: ExcelFilenameFilter.java
 * CreateTime: 2016年4月11日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.poi;

import java.io.File;
import java.io.FilenameFilter;

/**
 * TypeName: ExcelFilenameFilter
 * <P>TODO
 * 
 * <P>CreateTime: 2016年4月11日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public class ExcelFilenameFilter implements FilenameFilter {
	static final String OLD_EXCEL_EXTENSION = "-template.xls";
	static final String OOXML_EXCEL_EXTENSION = "-template.xlsx";
	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		boolean result = false;
		if (name.endsWith(OLD_EXCEL_EXTENSION) || name.endsWith(OOXML_EXCEL_EXTENSION)) {
			result = true;
		}
		return result;
	}

}
