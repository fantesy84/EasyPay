/**
 * Project net.fantesy84.poi
 * File: DataProcesser.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi;

import java.io.OutputStream;
import java.util.List;
import net.fantesy84.poi.description.TemplateDescription;

/**
 * TypeName: DataProcesser
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public interface DataHandler {
	<T> OutputStream fill(List<T> data, TemplateDescription desc) throws Exception;
	<T> OutputStream fill(List<T> data, TemplateDescription desc, FillStrategy strategie) throws Exception;
}
