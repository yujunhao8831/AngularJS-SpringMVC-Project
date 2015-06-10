package com.crm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.core.base.BaseController;
import com.crm.core.domain.PageResult;
import com.crm.domain.Goods;
import com.crm.domain.GoodsClassification;
import com.crm.utils.ExcelExportUtil;

@RestController
public class GoodsClassificationController extends BaseController<GoodsClassification> {
	
	@RequestMapping("/goodsClassification/download")  
	public void download(HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		String filename = "test";
		String path = makePath(filename,request.getSession().getServletContext().getRealPath("/WEB-INF/upload")); // 得到下载文件的目录
		
		File file = new File(path + "/" + filename); // 得到下载文件的全路径
		
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(path,"UTF-8")); // 对下载者提供的下载名
		
		FileInputStream in = new FileInputStream(path + "/" + filename); // 如果文件在的话,那么就准备下载
		OutputStream out = response.getOutputStream();//
		byte buff[] = new byte[1024];
		int len = 0;
		while((len = in.read(buff)) > 0)
		{
			out.write(buff, 0, len);
		}
		out.close();
		in.close();
		
	}  
	public String makePath(String filename,String savePath)
	{
		int hashcode = filename.hashCode(); // 
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode&0xf0)>>4;
		String dir = savePath + "/" + dir1 + "/" + dir2;
		File file = new File(dir); // 查看 dir 是否存在
		if(!file.exists()) 
		{
			file.mkdirs(); // 如果没有建立一个目录
		}
		return dir;
	}
	/** 导出Excel */
	@RequestMapping(value="/goodsClassification/export*",method=RequestMethod.GET)
	public String export(@RequestParam(value="ids") Long[] ids) {
		
		List<GoodsClassification> goodsClassificationList = (List<GoodsClassification>) goodsClassificationService.getByIds(ids);
		
		ExcelExportUtil.exportExcel(GoodsClassification.class, goodsClassificationList, "/Users/apple/Desktop/goodsClassification.xlsx");
		
		return "goodsClassification/list";
	}

	
	/** 显示所有商品类别 */
	@RequestMapping(value="/goodsClassification/list*",method=RequestMethod.GET)
	public PageResult list(HttpServletRequest request
			,@RequestParam(value="nextPageNumber",required=false,defaultValue="0") Integer nextPageNumber
			,@RequestParam(value="pageSize",required=false,defaultValue="10") Integer pageSize) {
		
		PageResult page = goodsClassificationService.findPage("", nextPageNumber, pageSize);
		page.setPageSize(pageSize);
		System.out.println("list() 方法被执行!!");
		return page;
	}

	/** 添加商品类别页面 */
	@RequestMapping(value="/goodsClassification/addUI*",method=RequestMethod.GET)
	public Map<String,Object> addUI() {
		
		Map<String,Object> map =  new HashMap<>();
		// 准备商品数据.
		List<Goods> goodsList = goodsService.findAll();
		map.put("goodsList", goodsList);
		return map;
	}

	/** 添加商品类别 */
	@RequestMapping(value="/goodsClassification/add*",method=RequestMethod.POST)
	public void add(@RequestParam(value="ids",required=false) Long[] ids,@RequestBody GoodsClassification goodsClassification) {
		
		if(ids != null){
			List<Goods> goodsList = (List<Goods>) goodsService.getByIds(ids);
			for (Goods goods : goodsList) {
				goods.getGoodsClassificationSet().add(goodsClassification);
			}
			System.out.println("-------------------------------");
		}
		
		goodsClassificationService.add(goodsClassification); // 保存类别
	}
	/** 修改商品类别页面 */
	@RequestMapping(value="/goodsClassification/editUI/{id}",method=RequestMethod.GET)
	public Map<String,Object> editUI(@PathVariable("id") Long id) {
		
		// 1. 准备需要修改的商品类别数据
		GoodsClassification goodsClassification = goodsClassificationService.get(id);
		Map<String,Object> modelList = new HashMap<>();
		modelList.put("model", goodsClassification);
		return modelList;
	}

	/** 修改商品类别 */
	@RequestMapping(value="/goodsClassification/edit",method=RequestMethod.PUT)
	public void edit(@RequestBody GoodsClassification goodsClassification) {
		
		Set<Goods> goodsSet = goodsClassification.getGoodsSet();
		// 因为,关系维护方在Goods
//		if(null != goodsSet){
//			for (Goods goods : goodsSet) {
//				goodsService.update(goods);
//			}
//		}
		
		goodsClassificationService.update(goodsClassification);
	}
	
	/** 删除商品类别 */
	@RequestMapping(value="/goodsClassification/delete*/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		goodsClassificationService.delete(id);
	}
	
	@ModelAttribute
	public void getGoodsClassification(@RequestParam(value="id",required=false) Long id,
			Map<String, Object> map){
		if(id != null){
			System.out.println("@ModelAttribute ->> 执行了");
			GoodsClassification goodsClassification = goodsClassificationService.get(id);
			System.out.println(goodsClassification.getId());
			System.out.println(goodsClassification.getName());
			System.out.println(goodsClassification.getGoodsSet());
			
			map.put("goodsClassification", goodsClassificationService.get(id));
		}
	}


	
	
	
}
