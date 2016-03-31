/**
 * Project net.fantesy84.poi.description
 * File: TemplateDescription.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi.description;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * TypeName: TemplateDescription
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public class TemplateDescription implements Serializable {
	private static final long serialVersionUID = -4297994125420948700L;
	private File templateFile;
	private String sheetName;
	private Map<String, Class<?>> headers;
	private Map<Integer, String> headerIndexMap;
	
	/**
	 * 
	 */
	public TemplateDescription() {
		super();
		this.headers = new HashMap<>();
		this.headerIndexMap = new HashMap<>();
	}
	
	/**
	 * @return the templateFile
	 */
	public File getTemplateFile() {
		return templateFile;
	}

	/**
	 * @param templateFile the templateFile to set
	 */
	public void setTemplateFile(File templateFile) {
		this.templateFile = templateFile;
	}

	/**
	 * @return the sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 * @param sheetName the sheetName to set
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * @return the headers
	 */
	public Map<String, Class<?>> getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, Class<?>> headers) {
		this.headers = headers;
	}
	/**
	 * @return the headerIndexMap
	 */
	public Map<Integer, String> getHeaderIndexMap() {
		return headerIndexMap;
	}

	/**
	 * @param headerIndexMap the headerIndexMap to set
	 */
	public void setHeaderIndexMap(Map<Integer, String> headerIndexMap) {
		this.headerIndexMap = headerIndexMap;
	}
	
}
