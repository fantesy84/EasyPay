/**
 * Project commons-poi
 * File: TemplateAliasGeneratorImpl.java
 * CreateTime: 2016年4月11日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.poi;

/**
 * TypeName: TemplateAliasGeneratorImpl
 * <P>TODO
 * 
 * <P>CreateTime: 2016年4月11日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public class TemplateAliasGeneratorImpl implements TemplateAliasGenerator {
	
	/* (non-Javadoc)
	 * @see net.fantesy84.poi.TemplateAliasGenerator#generate(java.lang.String)
	 */
	@Override
	public String generate(String name) throws Exception {
		int idx = name.lastIndexOf("-template");
		return name.substring(0, idx);
	}

}
