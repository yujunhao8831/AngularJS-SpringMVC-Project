package com.excle.my;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

/**
 * 通过POI读取Excel,目前只支持 xls 格式.
 */
@SuppressWarnings({ "unused", "resource" })
public class ExcelInputUtil {

	/**
	 * 根据 path(文件路径) 获取除了标题,的所有内容.
	 */
	public static List<Object> getExcelContentValue(String path) {
		// 1. 得到文件(以流的方式材操纵)
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			// 2. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 3. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);

			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			
			List<Object> contentList = new ArrayList<Object>();
			// 2. 得到标题下的内容的数据
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(1 + 1);
				for (Cell cell : rowContent) {
					Object value = getByType2CellValue(cell);
					contentList.add(value);
				}
			}
			return contentList;

			// --------------异常不用看----------
		} catch (OfficeXmlFileException o) {
			throw new RuntimeException("该Excel文档格式不支持,请使用xsl的格式进行操作!");
		} catch (FileNotFoundException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("没有找到文件路径!");
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	/**
	 * 根据 path(文件路径) 获取除了标题,的所有内容.
	 * isSplit : 每个单元格分隔条件.
	 */
	public static List<Object> getExcelContentValue(String path,String isSplit) {
		if(null == isSplit){
			isSplit = "";
		}
		// 1. 得到文件(以流的方式材操纵)
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			// 2. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 3. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			
			List<Object> contentList = new ArrayList<Object>();
			
			String result = "";
			// 2. 得到标题下的内容的数据
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(1 + 1);
				for (Cell cell : rowContent) {
					Object value = getByType2CellValue(cell);
					result += value + isSplit;
				}
				result = result.substring(0, result.length()-1);
				contentList.add(result); // 添加一行数据
			}
			return contentList;
			
			// --------------异常不用看----------
		} catch (OfficeXmlFileException o) {
			throw new RuntimeException("该Excel文档格式不支持,请使用xsl的格式进行操作!");
		} catch (FileNotFoundException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("没有找到文件路径!");
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	/**
	 * 根据 path 获取内容,得到标题那一行的值
	 */
	public static List<Object> getExcelTitleValue(String path) throws Exception {
		// 1. 得到文件(以流的方式材操纵)
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			// 2. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 3. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			HSSFRow rowTitle = sheet.getRow(0);

			// 4. 得到 title 的数据
			List<Object> titleList = new ArrayList<Object>();
			for (Cell cell : rowTitle) {
				Object value = getByType2CellValue(cell);
				titleList.add(value);
			}
			return titleList;
		} catch (OfficeXmlFileException o) {
			throw new RuntimeException("该Excel文档格式不支持,请使用xsl的格式进行操作!");
		} catch (FileNotFoundException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("没有找到文件路径!");
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 根据 path 获取内容,得到标题那一行的值
	 * isSplit : 每个单元格的分割条件
	 */
	public static List<Object> getExcelTitleValue(String path,String isSplit) throws Exception {
		if(null == isSplit){
			isSplit = "";
		}
		// 1. 得到文件(以流的方式材操纵)
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			// 2. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 3. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			HSSFRow rowTitle = sheet.getRow(0);
			String result = "";
			// 4. 得到 title 的数据
			List<Object> titleList = new ArrayList<Object>();
			for (Cell cell : rowTitle) {
				Object value = getByType2CellValue(cell);
				result += value + isSplit;
			}
			result = result.substring(0, result.length()-1);
			titleList.add(result);
			return titleList;
		} catch (OfficeXmlFileException o) {
			throw new RuntimeException("该Excel文档格式不支持,请使用xsl的格式进行操作!");
		} catch (FileNotFoundException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("没有找到文件路径!");
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 根据 inputStream 流,获取标题内容,得到标题那一行的数据
	 */
	public static List<Object> getExcelTitleValue(InputStream inputStream) {
		try {
			// 1. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 2. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			// 2. 得到第一行 : title
			HSSFRow rowTitle = sheet.getRow(0);
			
			// 3. 得到 title 的数据
			List<Object> titleList = new ArrayList<Object>();
			for (Cell cell : rowTitle) {
				Object value = getByType2CellValue(cell);
				titleList.add(value);
			}
			return titleList;
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	/**
	 * 根据 inputStream 流,获取标题内容,得到标题那一行的数据
	 * @param isSplit		: 每个单元格的分割条件
	 */
	public static List<Object> getExcelTitleValue(InputStream inputStream,String isSplit) {
		try {
			if(null == isSplit){
				isSplit = "";
			}
			// 1. 得到工作簿
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 2. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			// 2. 得到第一行 : title
			HSSFRow rowTitle = sheet.getRow(0);

			// 3. 得到 title 的数据
			List<Object> titleList = new ArrayList<Object>();
			String result = "";
			for (Cell cell : rowTitle) {
				Object value = getByType2CellValue(cell);
				result += value +  isSplit;
			}
			result = result.substring(0, result.length()-1);
			titleList.add(result);
			return titleList;
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
	

	/**
	 * 根据 inputStream 流,获取标题内容,得到标题下面所有的内容数据
	 */
	public static List<Object> getExcelContentValue(InputStream inputStream)  {
		try {
			// 1. 得到工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 2. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			
			List<Object> contentList = new ArrayList<Object>();
			// 2. 得到标题下的内容的数据
			String result = "";
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(i + 1);
				for (Cell cell : rowContent) {
					// 处理内容,每个单元格的内容,可以用某个符号进行分割.以区分每个单元格.
					Object value = getByType2CellValue(cell); // 这里是每个单元格的结果集.
					result += (value + "  "); // 这里是一行的结果集.
				}
				contentList.add(result);
				result = "";
			}
			return contentList;
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 根据 inputStream 流,获取标题内容,得到标题下面所有的内容数据
	 * @param inputStream 
	 * @param isSplit		: 每个单元格的分割条件
	 */
	public static List<Object> getExcelContentValue(InputStream inputStream,String isSplit)  {
		try {
			if(null == isSplit){
				isSplit = "";
			}
			// 1. 得到工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 2. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			
			List<Object> contentList = new ArrayList<Object>();
			// 2. 得到标题下的内容的数据
			String result = "";
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(i + 1);
				for (Cell cell : rowContent) {
					// 处理内容,每个单元格的内容,可以用某个符号进行分割.以区分每个单元格.
					Object value = getByType2CellValue(cell); // 这里是每个单元格的结果集.
					result += (value + isSplit); // 这里是一行的结果集.
				}
				result = result.substring(0, result.length()-1);
				
				contentList.add(result);
				result = "";
			}
			return contentList;
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("读取文件出错!");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 给我一个Cell(单元格[细胞]),我根据内容进行区分,然后处理,返回cell对应的值.
	 * 
	 * @param cell
	 * @return
	 */
	private static Object getByType2CellValue(Cell cell) {
		List<Object> cellValueList = new ArrayList<Object>();
		// 区分不同的类型,分别打印 (不这样会报错)
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断该数字是不是日期类型?
				Date date = cell.getDateCellValue();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String value = dateFormat.format(date);
				return value;
			} else {
				return cell.getNumericCellValue();
			}
		case HSSFCell.CELL_TYPE_FORMULA:
			try {
				// ->> 对于字符串cell.getStringCellValue()方法即可取得其值,如果公式生成的是数值
				// ->>
				// 使用cell.getStringCellValue()方法会抛出IllegalStateException异常，在异常处理中使用cell.getNumericCellValue();即可。
				return String.valueOf(cell.getStringCellValue());
			} catch (IllegalStateException e) {
				return String.valueOf(cell.getNumericCellValue());
			}
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue(); // 字符
		case HSSFCell.CELL_TYPE_BLANK:
			return ""; // 空,原样处理
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();// 布尔
		case HSSFCell.CELL_TYPE_ERROR:
			throw new RuntimeException("监测到异常数据!请及时处理!"); // 异常
		default:
			return cell.getStringCellValue();
		}
	}

	/**
	 * 作用 : 用于封装到Bean之前的判断 给我一个Cell(单元格[细胞]),我根据内容进行区分,然后该类型返回给你.
	 * 
	 * @param cell
	 * @return Class
	 */
	private static Class<?> caseCellType(Cell cell) {
		// 区分不同的类型,分别打印 (不这样会报错)
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC: // 数字
			if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断该数字是不是日期类型?
				return Date.class;
			}
			return Number.class;
		case HSSFCell.CELL_TYPE_FORMULA:
			try {
				// 对于字符串cell.getStringCellValue()方法即可取得其值,如果公式生成的是数值
				// 使用cell.getStringCellValue()方法会抛出IllegalStateException异常，在异常处理中使用cell.getNumericCellValue();即可。
				return String.class;
			} catch (IllegalStateException e) {
				return Number.class;
			}
		case HSSFCell.CELL_TYPE_STRING:
			return String.class; // 字符
		case HSSFCell.CELL_TYPE_BLANK:
			return null; // 空,原样处理
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return boolean.class; // 布尔
		case HSSFCell.CELL_TYPE_ERROR:
			throw new RuntimeException("监测到异常数据!请及时处理!"); // 异常
		default:
			return String.class;
		}
	}
}
