/**
 * Project net.fantesy84.poi
 * File: DataHandlerImpl.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.fantesy84.poi.description.TemplateDescription;

/**
 * TypeName: DataHandlerImpl
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public class DataHandlerImpl implements DataHandler {
	
	/* (non-Javadoc)
	 * @see net.fantesy84.poi.DataHandler#fill(java.util.List, net.fantesy84.poi.description.TemplateDescription)
	 */
	@Override
	public <T> OutputStream fill(List<T> data, TemplateDescription desc) throws Exception {
		return this.fill(data, desc, new DefaultFillStrategyImpl());
	}

	/* (non-Javadoc)
	 * @see net.fantesy84.poi.DataHandler#fill(java.util.List, net.fantesy84.poi.description.TemplateDescription, net.fantesy84.poi.FillStrategy[])
	 */
	@Override
	public <T> OutputStream fill(List<T> data, TemplateDescription desc, FillStrategy strategie) throws Exception {
		Workbook wb = WorkbookFactory.create(desc.getTemplateFile());
		Sheet sheet = wb.getSheet(desc.getSheetName());
		Map<Integer, String> headerIndexMap = desc.getHeaderIndexMap();
		Map<String, Class<?>> headers = desc.getHeaders();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) == null) {
				continue;
			}
			//row begin at 1(actual row 2)
			Row row = sheet.getRow(i+1);
			for (Integer index : headerIndexMap.keySet()) {
				Cell cell = row.getCell(index);
				String propertyName = headerIndexMap.get(index);
				Class<?> javaType = headers.get(propertyName);
				if (strategie != null) {
					strategie.fill(cell, propertyName, javaType, data.get(i));
				} else {
					throw new IllegalArgumentException("Strategy of filling cell is necessary! Please implemention net.fantesy84.poi.FillStrategy interface");
				}
			}
		}
		OutputStream os = new ByteArrayOutputStream(4096);
		wb.write(os);
		wb.close();
		return os;
	}

}
