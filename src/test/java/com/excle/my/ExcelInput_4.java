package com.excle.my;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

/**
 * 4.0 版,成功读取excel文件,并打印
 * 	 进行封装,使之优雅
 * 
 */
public class ExcelInput_4 {
	@Test
	public void testInput() throws Exception {
		// 1. 得到文件(以流的方式材操纵)
		InputStream inputStream = new FileInputStream("/Users/apple/Desktop/POI测试文件夹/MyExcel.xls");
		// 2. 得到工作簿
		HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
		// 3. 得到工作表
		HSSFSheet sheet = workbook.getSheetAt(0);
		// ----------------------------begin-------------------------------
		// 1. 得到总行数
		int rowNum = sheet.getLastRowNum();
		// 2. 得到第一行 : title
		HSSFRow rowTitle = sheet.getRow(0);
		System.out.println("-------标题-------");
		// 4. 得到 title 的数据
		for(Cell cell : rowTitle){
			Object value = getByType2CellValue(cell);
			System.out.println(value);
		}
		System.out.println("-------内容-------");
		// 5. 得到标题下的内容的数据
		HSSFRow rowContent = sheet.getRow(1);
		for (int i = 0; i < rowNum; i++) {
			for(Cell cell : rowContent){
				Object value = getByType2CellValue(cell);
				System.out.println(value);
			}
		}
	}
	
	/**
	 * 给我一个Cell(单元格[细胞]),我根据内容进行区分,然后处理,返回cell对应的值.
	 * @param   cell
	 * @return
	 */
	private Object getByType2CellValue(Cell cell){
		List<Object> cellValueList = new ArrayList<Object>();
		// 区分不同的类型,分别打印 (不这样会报错)
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC  : 
				if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断该数字是不是日期类型?
					Date date = cell.getDateCellValue();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String value = dateFormat.format(date);
					return value;
				} else {
					return cell.getNumericCellValue();
				}
			case HSSFCell.CELL_TYPE_FORMULA  : 
				try {  
					// ->> 对于字符串cell.getStringCellValue()方法即可取得其值,如果公式生成的是数值
					// ->> 使用cell.getStringCellValue()方法会抛出IllegalStateException异常，在异常处理中使用cell.getNumericCellValue();即可。
					return String.valueOf(cell.getStringCellValue());  
				} catch (IllegalStateException e) {  
					return String.valueOf(cell.getNumericCellValue());  
				} 
			case HSSFCell.CELL_TYPE_STRING   : return cell.getStringCellValue(); // 字符
			case HSSFCell.CELL_TYPE_BLANK    : return "";						 // 空,原样处理
			case HSSFCell.CELL_TYPE_BOOLEAN  : return cell.getBooleanCellValue();// 布尔 
			case HSSFCell.CELL_TYPE_ERROR    : throw new RuntimeException("监测到异常数据!请及时处理!"); // 异常
			default : return cell.getStringCellValue();
		}
	}
	
	/**
	 * 作用 : 用于封装到Bean之前的判断
	 * 给我一个Cell(单元格[细胞]),我根据内容进行区分,然后该类型返回给你.
	 * @param  cell
	 * @return Class
	 */
	private Class<?> caseCellType(Cell cell){
		// 区分不同的类型,分别打印 (不这样会报错)
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC  :  // 数字
				if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断该数字是不是日期类型?
					return Date.class;
				}
				return Number.class; 
			case HSSFCell.CELL_TYPE_FORMULA  : 
				try {  
					// 对于字符串cell.getStringCellValue()方法即可取得其值,如果公式生成的是数值
					// 使用cell.getStringCellValue()方法会抛出IllegalStateException异常，在异常处理中使用cell.getNumericCellValue();即可。
					return String.class;
				} catch (IllegalStateException e) {  
					return Number.class;
				}
			case HSSFCell.CELL_TYPE_STRING   : return String.class; // 字符
			case HSSFCell.CELL_TYPE_BLANK    : return null; // 空,原样处理
			case HSSFCell.CELL_TYPE_BOOLEAN  : return boolean.class; // 布尔 
			case HSSFCell.CELL_TYPE_ERROR    : throw new RuntimeException("监测到异常数据!请及时处理!"); // 异常
			default : return String.class;
		}
	}
	
}





