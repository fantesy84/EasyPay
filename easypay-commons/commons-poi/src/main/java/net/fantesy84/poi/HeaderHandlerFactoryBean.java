/**
 * Project net.fantesy84.poi.description
 * File: ExcelTemplateReaderImpl.java
 * CreateTime: 2016年3月31日
 * Creator: junjie.ge
 * copy right ©2016 葛俊杰
 */
package net.fantesy84.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fantesy84.poi.description.TemplateDescription;

/**
 * TypeName: ExcelTemplateReaderImpl
 * 
 * CreateTime: 2016年3月31日
 * UpdateTime: 
 * @author junjie.ge
 *
 */
public class HeaderHandlerFactoryBean implements HeaderHandler {
	private static final Logger logger = LoggerFactory.getLogger(HeaderHandlerFactoryBean.class);
	private Map<String, TemplateDescription> descriptions;
	private final int HEAD_ROW_INDEX = 0;
	private final int SINGLE_SHEET_INDEX = 0;
	private final String SYSTEM_TEMP_PATH_KEY = "java.io.tmpdir";
	private Integer headRowIndex = HEAD_ROW_INDEX;
	private Integer sheetIndex = SINGLE_SHEET_INDEX;
	private String locations;
	
	/**
	 * 
	 */
	public HeaderHandlerFactoryBean() {
		super();
		this.descriptions = new ConcurrentHashMap<>();
	}
	protected void init() throws Exception {
		if (locations != null) {
			String[] eles = null;
			if (locations.contains(",")) {
				eles = locations.split(",");
			} else if (locations.contains(";")) {
				eles = locations.split(";");
			} else {
				eles = new String[]{locations};
			}
			for (int i = 0; i < eles.length; i++) {
				
			}
			this.load(eles);
		} else {
			throw new IllegalArgumentException("必须指定模板路径!");
		}
	}
	/* (non-Javadoc)
	 * @see net.fantesy84.poi.description.TemplateReader#load(java.lang.String[])
	 */
	@Override
	public void load(String... templatePath) throws Exception {
		for (int i = 0; i < templatePath.length; i++) {
			logger.debug("开始加载模板文件: {}", templatePath[i]);
			File templateFile = new File(templatePath[i]);
			loadCommentTemplate(templateFile);
		}
	}
	/* (non-Javadoc)
	 * @see net.fantesy84.poi.description.TemplateHandler#load(java.io.InputStream)
	 */
	@Override
	public void load(InputStream in) throws Exception {
		String tmpdir = System.getProperty(SYSTEM_TEMP_PATH_KEY);
		File templateFile = new File(tmpdir);
		OutputStream os = new FileOutputStream(tmpdir);
		int bytesRead = 0;
		byte[] buffer = new byte[4096];
		logger.debug("将输入流转成临时目录的File文件对象");
		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
		      os.write(buffer, 0, bytesRead);
		}
		os.close();
		in.close();
		loadCommentTemplate(templateFile);
	}
	/* (non-Javadoc)
	 * @see net.fantesy84.poi.description.TemplateHandler#getDescriptions()
	 */
	@Override
	public Map<String, TemplateDescription> getDescriptions() {
		return this.descriptions;
	}
	/**
	 * 创建模板Excel的描述信息
	 * @param templateFile 模板File对象
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private void loadCommentTemplate(File templateFile) throws IOException, InvalidFormatException {
		TemplateDescription templateDesc = new TemplateDescription();
		templateDesc.setTemplateFile(templateFile);
		Workbook wb = WorkbookFactory.create(templateFile);
		Sheet sheet = wb.getSheetAt(sheetIndex);
		Row headRow = sheet.getRow(headRowIndex);
		Map<String, Class<?>> headers = templateDesc.getHeaders();
		for (Cell cell : headRow) {
			Comment comment = cell.getCellComment();
			if (comment != null) {
				String name = comment.getString().getString();
				Class<?> cellType = null;
				int typeCode = cell.getCellType();
				switch (typeCode) {
				case Cell.CELL_TYPE_BOOLEAN:
					cellType = Boolean.class;
					break;
				case Cell.CELL_TYPE_FORMULA:
					cellType = String.class;
					break;
				case Cell.CELL_TYPE_NUMERIC:
					cellType = Number.class;
					break;
				default:
					cellType = String.class;
					break;
				}
				headers.put(name, cellType);
			}
		}
		templateDesc.setSheetName(sheet.getSheetName());
		descriptions.put(templateFile.getName(), templateDesc);
		wb.close();
	}
	/**
	 * @param headRowIndex the headRowIndex to set
	 */
	public void setHeadRowIndex(Integer headRowIndex) {
		this.headRowIndex = headRowIndex;
	}
	/**
	 * @param sheetIndex the sheetIndex to set
	 */
	public void setSheetIndex(Integer sheetIndex) {
		this.sheetIndex = sheetIndex;
	}
	/**
	 * @param locations the locations to set
	 */
	public void setLocations(String locations) {
		this.locations = locations;
	}
	
}
