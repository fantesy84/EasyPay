/**
 * Project commons-poi
 * File: TemplateReaderTest.java
 * CreateTime: 2016年4月11日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.test.poi;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import net.fantesy84.poi.TemplateReader;
import net.fantesy84.poi.TemplateReaderBuilder;
import net.fantesy84.poi.TemplateReaderFactoryBean;
import net.fantesy84.poi.description.TemplateDescription;

/**
 * TypeName: TemplateReaderTest
 * <P>TODO
 * 
 * <P>CreateTime: 2016年4月11日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
public class TemplateReaderTest {
	private TemplateReader reader;
	
	@Before
	public void init(){
		reader = TemplateReaderBuilder.init();
	}
	
	@Test
	public void testLoad() throws Exception{
		reader.load("classpath:paycurrency-template.xlsx");
		TemplateDescription desc = reader.getDescriptions().get("paycurrency-template.xlsx");
		System.out.println(desc.getSheetName());
		System.out.println(desc.getTemplateFile().getPath());
		System.out.println(desc.getHeaders());
		System.out.println(desc.getHeaderIndexMap());
	}
	
	@Test
	public void testSpringLoad() throws Exception {
		TemplateReaderFactoryBean fb = new TemplateReaderFactoryBean();
		fb.setTemplatesDirectory("classpath:excel-template");
		fb.init();
		reader = fb;
		Map<String, TemplateDescription> map = reader.getDescriptions();
		System.out.println(map);
		TemplateDescription desc = map.get("buycurrency");
		System.out.println(desc.getSheetName());
		System.out.println(desc.getTemplateFile().getPath());
		System.out.println(desc.getHeaders());
		System.out.println(desc.getHeaderIndexMap());
	}
}
