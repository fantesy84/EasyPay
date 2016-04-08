/**
 * Project commons-utils
 * File: FileScanner.java
 * CreateTime: 2016年4月8日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TypeName: FileScanner
 * <P>TODO
 * 
 * <P>CreateTime: 2016年4月8日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public abstract class FileScanner {
	private static final Logger logger = LoggerFactory.getLogger(FileScanner.class);
	public String[] getFileList(String str) throws Exception{
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("被扫描的路径不能为空!");
		}
		String[] eles = str.split(",");
		if (eles == null || eles.length == 0) {
			eles = str.split(";");
			if (eles == null || eles.length == 0) {
				eles = str.split("|");
				if (eles == null || eles.length == 0) {
					eles = new String[]{str};
				}
			}
		}
		if (eles != null && eles.length > 0) {
			for (int i = 0; i < eles.length; i++) {
				String[] temps = eles[i].split("*");
				
			}
		} else {
			
		}
		return null;
	}
}
