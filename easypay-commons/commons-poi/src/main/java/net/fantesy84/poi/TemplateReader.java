/**
 * Project net.fantesy84.poi.description
 * File: TemplateDescriptionReader.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi;

import java.io.InputStream;
import java.util.Map;

import net.fantesy84.poi.description.TemplateDescription;

/**
 * TypeName: TemplateDescriptionReader
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public interface TemplateReader {
	/**
	 * 从指定路径读取一个或多个Excel模板
	 * @param templatePath 模板路径
	 * @throws Exception
	 */
	void load(String... templatePath) throws Exception;
	
	/**
	 * 从内存中读取<strong>一个</strong>Excel模板,多用于从远端获取到的模板文件读取
	 * @param in 输入流(一般为文件流或二进制流)
	 * @throws Exception
	 */
	void load(InputStream in) throws Exception;
	
	Map<String, TemplateDescription> getDescriptions();
}
