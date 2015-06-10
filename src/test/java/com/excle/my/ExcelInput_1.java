package com.excle.my;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

/**
 * 1.0 版,成功读取excel文件,并打印 
 * 
 */
public class ExcelInput_1 {
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
			System.out.println(cell.getStringCellValue());
		}
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
