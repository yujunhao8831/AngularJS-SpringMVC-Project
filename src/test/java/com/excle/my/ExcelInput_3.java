package com.excle.my;

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
 * 3.0 版,成功读取excel文件,并打印
 * 	 进行封装.
 *   HSSFCell.CELL_TYPE_NUMERIC  //数字
 *	 HSSFCell.CELL_TYPE_STRING   //字符	
 *	 HSSFCell.CELL_TYPE_FORMULA  //公式
 *	 HSSFCell.CELL_TYPE_BLANK    //空
 *	 HSSFCell.CELL_TYPE_BOOLEAN  //布尔
 *	 HSSFCell.CELL_TYPE_ERROR    //异常
 * 
 */
public class ExcelInput_3 {
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
		List<Object> titleList = new ArrayList<Object>();
		for(Cell cell : rowTitle){
			// 区分不同的类型,分别打印 (不这样会报错)
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC  :  // 数字
				if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断该数字是不是日期类型?
					Date date = cell.getDateCellValue();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String str = dateFormat.format(date);
					System.out.println(str);
				}
				System.out.println(cell.getNumericCellValue());
				break; 
			case HSSFCell.CELL_TYPE_FORMULA  : 
				try {  
					titleList.add(String.valueOf(cell.getStringCellValue()));  
				} catch (IllegalStateException e) {  
					titleList.add(String.valueOf(cell.getNumericCellValue()));  
				}; // 对于字符串cell.getStringCellValue()方法即可取得其值,如果公式生成的是数值
				   // 使用cell.getStringCellValue()方法会抛出IllegalStateException异常，在异常处理中使用cell.getNumericCellValue();即可。
			break;
			case HSSFCell.CELL_TYPE_STRING   : titleList.add(cell.getStringCellValue());  break; // 字符
			case HSSFCell.CELL_TYPE_BLANK    : titleList.add(cell.getStringCellValue());  break; // 空,原样处理
			case HSSFCell.CELL_TYPE_BOOLEAN  : titleList.add(cell.getBooleanCellValue()); break; // 布尔 
			case HSSFCell.CELL_TYPE_ERROR    : throw new RuntimeException("数据异常"); // 异常
			
			default : titleList.add(cell.getStringCellValue()); break;
			}
		}
		System.out.println(titleList);
		System.out.println("-------内容-------");
		// 5. 得到标题下的内容的数据
		HSSFRow rowContent = sheet.getRow(1);
		for (int i = 0; i < rowNum; i++) {
			for(Cell cell : rowContent){
				System.out.println(cell.getStringCellValue());
			}
		}


		
	}
}
