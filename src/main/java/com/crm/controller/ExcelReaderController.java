package com.crm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crm.test.utils.ExcelReader;
import com.crm.utils.ExcelImportUtil;

@Controller
public class ExcelReaderController {
	
	@RequestMapping(value="/excelReader/list")
	public String list(){
		
		return "excelReader/list";
	}
	@RequestMapping(value="/excelReader/reader")
	public String reader(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		
		List<Object> titleList = ExcelImportUtil.getExcelTitleValue(file.getInputStream());
		
		Map<Integer,List<Object>> contentMap  = ExcelImportUtil.getExcelContentValue(file.getInputStream());
		
        request.setAttribute("contentMap", contentMap);
        request.setAttribute("titleList", titleList);
		
		return "excelReader/reader";
	}
	
	@RequestMapping(value="/excelReader/export")
	public String export(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		
//		List<Object> titleList = ExcelImportUtil.getExcelTitleValue(file.getInputStream());
//		List<Object> contentList  = ExcelImportUtil.getExcelContentValue(file.getInputStream(),",");
//		request.setAttribute("contentList", contentList);
//		request.setAttribute("titleList", titleList);
//		
		return "excelReader/export";
	}
//	@RequestMapping(value="/excelReader/reader")
//	public String reader(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
//		
//		try {
//			// 对读取Excel表格标题测试
//			InputStream titleInput = file.getInputStream();
//			ExcelReader excelReader = new ExcelReader();
//			String[] title = excelReader.readExcelTitle(titleInput);
//			
//			// 获得Excel表格的标题
//			List<String> headerList = new ArrayList<String>(); 
//			for (String s : title) {
//				headerList.add(s);
//			}
//			
//			List<String> contentList = new ArrayList<String>(); 
//			
//			// 对读取Excel表格内容测试
//			InputStream contentInput = file.getInputStream();
//			
//			Map<Integer, String> map = excelReader.readExcelContent(contentInput);
//			// 获得Excel表格的内容:
//			
//			for (int i = 1; i <= map.size(); i++) {
//				contentList.add(map.get(i));
//			}
//			
//			request.setAttribute("contentList", contentList);
//			request.setAttribute("headerList", headerList);
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("未找到指定路径的文件!");
//			e.printStackTrace();
//		}
//		
//		return "excelReader/reader";
//	}
	
	
}
