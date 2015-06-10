package com.crm.utils;

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
public class ExcelImportUtil {
	
	@Test
	public void testName() throws Exception {
//		InputStream inputStream = new FileInputStream("/Users/apple/Desktop/项目.xls");
//		Map<Integer,List<Object>> contentMap  = ExcelImportUtil.getExcelContentValue(inputStream);
//		for (Map.Entry<Integer,	List<Object>> entry : contentMap.entrySet()) {
//			System.out.println(entry);
//		}
//		Map<Integer,List<Object>> contentMap  = ExcelImportUtil.getExcelContentValue("/Users/apple/Desktop/项目.xls");
//		for (Map.Entry<Integer,	List<Object>> entry : contentMap.entrySet()) {
//			System.out.println(entry);
//		}
	}

	/**
	 * 根据 inputStream 流,获取标题内容,得到标题下面所有的内容数据
	 * @param inputStream 
	 * return map 			: value -> 每行数据的集合
	 * <c:forEach items="${contentMap }" var="map"> 
				<c:forEach items="${map.value }" var="value">
					${value }
				</c:forEach>
		</c:forEach>
	 */
	public static Map<Integer, List<Object>> getExcelContentValue(String path) {
		/** 存放每行的数据 **/
		Map<Integer,List<Object>> contentMap = new HashMap<Integer,List<Object>>();
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
			
			List<Object> contentRowList = null;
			// 2. 得到标题下的内容的数据
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(i + 1);
				contentRowList = new ArrayList<Object>();
				for (Cell cell : rowContent) {
					Object value = getByType2CellValue(cell); // 这里是每个单元格的结果集.
					contentRowList.add(value);
				}
				contentMap.put(i, contentRowList);
			}
			return contentMap;

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
	public static List<Object> getExcelTitleValue(String path){
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
	 * 根据 inputStream 流,获取标题内容,得到标题下面所有的内容数据
	 * @param inputStream 
	 * return map 			: value -> 每行数据的集合 
	 * 
	 * <c:forEach items="${contentMap }" var="map"> 
			<c:forEach items="${map.value }" var="value">
				${value }
			</c:forEach>
		</c:forEach>
	 */
	public static Map<Integer,List<Object>> getExcelContentValue(InputStream inputStream)  {
		/** 存放每行的数据 **/
		Map<Integer,List<Object>> contentMap = new HashMap<Integer,List<Object>>();
		
		try {
			// 1. 得到工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
			// 2. 得到工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ----------------------------begin-------------------------------
			// 1. 得到总行数
			int rowNum = sheet.getLastRowNum();
			
			List<Object> contentRowList = null;
			// 2. 得到标题下的内容的数据
			for (int i = 0; i < rowNum; i++) {
				HSSFRow rowContent = sheet.getRow(i + 1);
				contentRowList = new ArrayList<Object>();
				for (Cell cell : rowContent) {
					Object value = getByType2CellValue(cell); // 这里是每个单元格的结果集.
					contentRowList.add(value);
				}
				contentMap.put(i, contentRowList);
			}
			return contentMap;
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
