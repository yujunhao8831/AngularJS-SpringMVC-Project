package com.crm.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * 使用POI实现动态添加,数据到Excel中,并保存到硬盘中.
 * @author 余峻豪
 */
@SuppressWarnings("resource")
public abstract class ExcelExportUtil {
	/**
	 * 
	 * @param clazz		 : 哪个实体类的数据进行导出
	 * @param list : 该实体类的数据
	 * @param titleList	 : 导出后标题行(第一行)的内容
	 * @param path		 : 导入到什么位置
	 */
	public static <T> void exportExcel(final Class<T> clazz,final List<T> list,final List<String> titleList,final String path)  {
		FileOutputStream out = null;
		SXSSFWorkbook workbook = null;
		// 判断标题是否为空
		if(null == titleList){
			// 如果为空,使用默认默认标题方法.
			exportExcel(clazz,list,path);
		}
		
		try {
			// workbook = new SXSSFWorkbook(-1); // 关闭自动冲洗，并堆积在内存中的所有行
			// 一. 创建一个新的工作簿
			workbook = new SXSSFWorkbook(100); // 保持100行内存，超出行会刷新到磁盘
			// 二. 在该工作表簿上创建一个新的工作表
			Sheet sheet = workbook.createSheet();
			// 三. 对内容的操作
			// ------------------------begin------------------------------------
			Method[] methods = clazz.getMethods(); 
			/**
			 * 0. 创建标题行.
			 * 1. 得到方法名.
			 * 2. 对方法名进行处理,得到字段名(首字母大写).
			 * 3. 创建单元格并,赋值
			 */
			Row titleRow = sheet.createRow(0); 
			int cellNum = 0;
			int fieldSize = 0; // 用于记录有多少个字段.
			int titleIndex = 0;
			for (Method method : methods) {
				// method.getName() : 得到方法名
				if(method.getName().matches("^get.*") && !method.getName().matches("^getClass")){ 
					titleRow.createCell(cellNum++).setCellValue(titleList.get(titleIndex++));
					fieldSize++;
				}
				else if(method.getName().matches("^is.*")){
					titleRow.createCell(cellNum++).setCellValue(titleList.get(titleIndex++));
					fieldSize++;
				}
			}
			if(fieldSize != titleList.size()){
				throw new RuntimeException("提供的标题,似乎与实体的字段不相符,请检查!");
			}
			
			/**
			 *  1. 遍历集合
			 *  2. 在该工作表上,根据集合大小创建相应的行
			 *  3. 反射获取Bean数据
			 *  4. 创建单元格,并把Bean的数据添加到单元格中
			 */
			for (int i = 0; i < list.size(); i++) {
				Row contentRow = sheet.createRow(i + 1); // 集合有多少个对象,就创建多少行, +1 是为了空出一行留给标题.
				T object = (T) list.get(i); // 得到某一个对象
				list.get(i); // 得到某一个对象
				int index = 0;
				for (Method method : methods) {
					if (method.getName().matches("^get.*") || method.getName().matches("^is.*")) { // 得到get方法
						if (method.getName().equalsIgnoreCase("getClass")) { // 排除 getClass
							continue; 
						}
						method.setAccessible(true); // 暴力反射.
						Object value = method.invoke(object, null); // 反射调用 get方法获取值
						/**
						可以根据不同的值类型进行不同的操作,这里伏笔. TODO 有需求在修改.
						if (value instanceof Boolean) {
						} else if (value instanceof Date) {
						} 
						 **/
						contentRow.createCell(index++).setCellValue(value + ""); // 创建单元格并设置值
					}
				}
				
			}
			// end. 写入硬盘中
			out = new FileOutputStream(path);
			
		}catch (InvocationTargetException e) {
			throw new RuntimeException("反射失败!",e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件没用找到!",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("反射获取失败!",e);
		}finally{
			try {
				workbook.write(out);
				out.close();
				workbook.dispose();
				if(null != workbook){
					workbook = null;
				}
				if(null != out){
					out = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 默认标题(第一行)为字段的名字(首字母大写)
	 * @param clazz		 : 对哪个实体类的数据进行导出
	 * @param list : 该实体类的数据
	 * @param path       : 导入到什么位置
	 */
	public static <T> void exportExcel(final Class<T> clazz,final List<T> list,final String path)  {
		FileOutputStream out = null;
		SXSSFWorkbook workbook = null;
		try {
			// workbook = new SXSSFWorkbook(-1); // 关闭自动冲洗，并堆积在内存中的所有行
			// 一. 创建一个新的工作簿
			workbook = new SXSSFWorkbook(100); // 保持100行内存，超出行会刷新到磁盘
			// 二. 在该工作表簿上创建一个新的工作表
			Sheet sheet = workbook.createSheet();
			// 三. 对内容的操作
			// ------------------------begin------------------------------------
			Method[] methods = clazz.getMethods(); 
			
			/**
			 * 0. 创建标题行.
			 * 1. 得到方法名.
			 * 2. 对方法名进行处理,得到字段名(首字母大写).
			 * 3. 创建单元格并,赋值
			 */
			Row titleRow = sheet.createRow(0); 
			int cellNum = 0;
			for (Method method : methods) {
				// method.getName() : 得到方法名
				if(method.getName().matches("^get.*") && !method.getName().matches("^getClass")){ 
					String titleName = method.getName().substring(3, method.getName().length());
					titleRow.createCell(cellNum++).setCellValue(titleName + " ");;
				}
				else if(method.getName().matches("^is.*")){
					String titleName = method.getName().substring(2, method.getName().length());
					titleRow.createCell(cellNum++).setCellValue(titleName + " ");;
				}
			}
			
			/**
			 *  1. 遍历集合
			 *  2. 在该工作表上,根据集合大小创建相应的行
			 *  3. 反射获取Bean数据
			 *  4. 创建单元格,并把Bean的数据添加到单元格中
			 */
			for (int i = 0; i < list.size(); i++) {
				Row contentRow = sheet.createRow(i + 1); // 集合有多少个对象,就创建多少行, +1 是为了空出一行留给标题.
				T object = (T) list.get(i); // 得到某一个对象
				list.get(i); // 得到某一个对象
				int index = 0;
				for (Method method : methods) {
					if (method.getName().matches("^get.*") || method.getName().matches("^is.*")) { // 得到get方法
						if (method.getName().equalsIgnoreCase("getClass")) { // 排除 getClass
							continue; 
						}
						method.setAccessible(true); // 暴力反射.
						Object value = method.invoke(object, null); // 反射调用 get方法获取值
						/**
						可以根据不同的值类型进行不同的操作,这里伏笔. TODO 有需求在修改.
						if (value instanceof Boolean) {
						} else if (value instanceof Date) {
						} 
						**/
						contentRow.createCell(index++).setCellValue(value + ""); // 创建单元格并设置值
					}
				}

			}
			// end. 写入硬盘中
			out = new FileOutputStream(path);
			
		}catch (InvocationTargetException e) {
			throw new RuntimeException("反射失败!",e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件没用找到!",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("反射获取失败!",e);
		}finally{
			try {
				workbook.write(out);
				out.close();
				workbook.dispose();
				if(null != workbook){
					workbook = null;
				}
				if(null != out){
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
