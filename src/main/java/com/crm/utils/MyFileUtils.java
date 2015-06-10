package com.crm.utils;

import java.io.File;

public class MyFileUtils {
	
	/**
	 * 文件打散算法,分散存储
	 * @param filePath  : 文件存储位置
	 * @param fileName  : 文件存储名
	 * @return
	 */
	public static String FileDiffuse(String filePath,String fileName) {
		int hashcode = fileName.hashCode(); // 
		int filePath1 = hashcode&0xf;
		int filePath2 = (hashcode&0xf0)>>4;
		
		/** Linux,Mac 下使用这种方式 **/
		filePath = filePath + "/" + filePath1 + "/" + filePath2; 
		/** window 下使用这种方式 **/
		// filePath = filePath + "/" + filePath1 + "/" + filePath2;
		
		// 1. 查看 dir 是否存在
		File file = new File(filePath);
		// 如果不存在,那么新建立一个目录
		if(!file.exists()) 
		{
			file.mkdirs(); // 如果没有建立一个目录
		}
		return filePath;
	}

}
