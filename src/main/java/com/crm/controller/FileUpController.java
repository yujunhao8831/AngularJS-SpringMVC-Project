package com.crm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crm.core.base.BaseController;
import com.crm.utils.MyFileUtils;

@Controller
public class FileUpController extends BaseController<Object> {

	@RequestMapping(value = "/fileUp/list*")
	public String list() {

		return "fileUp/list";
	}

	@RequestMapping(value = "/fileUp/fileUp*")
	public String fileUp(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		
		if (!file.isEmpty()) {
			ServletContext sc = request.getSession().getServletContext();
			String filePath = sc.getRealPath("/upload"); // 设定文件保存的目录 ->> /usr/local/apache-tomcat-8.0.21/me-webapps/PhotoCRM/upload/

			// 1. 得到上传时的文件名 + UUID 防止重名
			String filename = file.getOriginalFilename() + "_" + UUID.randomUUID().toString(); 
			
			// 2. 将文件打散
			filePath = MyFileUtils.FileDiffuse(filePath,filename);
			// 3. 存储
			FileUtils.writeByteArrayToFile(new File(filePath, filename), file.getBytes());
		}
		return "redirect:/fileUp/list";
	}
}
