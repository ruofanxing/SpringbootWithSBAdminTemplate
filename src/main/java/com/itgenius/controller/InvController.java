package com.itgenius.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.itgenius.beans.InvDetail;
import com.itgenius.beans.Product;
import com.itgenius.repository.InvDetailDao;
import com.itgenius.repository.ProductDao;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class InvController {
	@Autowired
	private InvDetailDao invDetailDao;
    @GetMapping("inv/export")
    public void exportIvn(HttpServletResponse response,@RequestParam(value = "invId") long invId) {
		List<InvDetail> invDetails = invDetailDao.findByInvId(invId);
		ExcelWriter excelWriter = ExcelUtil.getWriter(true);
		excelWriter.setRowHeight(0, 25);
		excelWriter.addHeaderAlias("invId", "盘点ID");
		excelWriter.addHeaderAlias("prodId", "资产ID");
		excelWriter.addHeaderAlias("status", "状态");
		// 4.设置表头字体
		// 获取表头样式，获取样式后可自定义样式
		CellStyle headCellStyle = excelWriter.getHeadCellStyle();
		// 设置内容字体
		Font font = excelWriter.createFont();
		// 设置字体
		font.setFontName("宋体");
		// 设置字体大小
		font.setFontHeightInPoints((short) 14);
		// 字体加粗
		font.setBold(true);
		// 字体颜色
		font.setColor(Font.SS_NONE);
		headCellStyle.setFont(font);
 
		// 5.设置单元格宽度
		int[] arr = {30, 30, 25};
		for (int i = 0; i < arr.length; i++) {
          excelWriter.setColumnWidth(i, arr[i]);
		}
		excelWriter.setOnlyAlias(true);
		// 一次性写出内容，使用默认样式，强制输出标题
		excelWriter.write(invDetails, true);
		try {
          String fileName = URLEncoder.encode("invId", StandardCharsets.UTF_8.name());
          response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
          response.setCharacterEncoding("utf-8");
          response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
          // 将Excel Workbook刷出到输出流
          excelWriter.flush(response.getOutputStream());
		} catch (IOException e) {
          e.printStackTrace();
          throw new RuntimeException("文件写入失败！");
		}
		//关闭流
		excelWriter.close();
    }
//	@PostMapping("inv/export")
//	public void exportIvn(HttpServletResponse response, long invId) {
//		List<InvDetail> invDetails = invDetailDao.findByInvId(invId);
//		// 1.创建ExcelWriter
//		// 通过工具类创建writer，默认创建xls格式
//		ExcelWriter excelWriter = ExcelUtil.getWriter();
//		//创建xlsx格式的
//		//ExcelWriter writer = ExcelUtil.getWriter(true);
//
//		// 2.设置一级标题
//		// 合并单元格后的标题行，使用默认标题样式，从0开始
//		excelWriter.merge(2, "学生记录");
//		// 设置表头高度
//		excelWriter.setRowHeight(0, 25);
//
//		// 3.设置二级标题
//		excelWriter.addHeaderAlias("name", "姓名");
//		excelWriter.addHeaderAlias("age", "年龄");
//		excelWriter.addHeaderAlias("sex", "性别");
//
//		// 4.设置表头字体
//		// 获取表头样式，获取样式后可自定义样式
//		CellStyle headCellStyle = excelWriter.getHeadCellStyle();
//		// 获取单元格样式
////        CellStyle cellStyle = excelWriter.getCellStyle();
//		// 设置内容字体
//		Font font = excelWriter.createFont();
//		// 设置字体
//		font.setFontName("宋体");
//		// 设置字体大小
//		font.setFontHeightInPoints((short) 14);
//		// 字体加粗
//		font.setBold(true);
//		// 字体颜色
//		font.setColor(Font.SS_NONE);
//		headCellStyle.setFont(font);
//
//		// 5.设置单元格宽度
//		int[] arr = {30, 30, 25};
//		for (int i = 0; i < arr.length; i++) {
//			excelWriter.setColumnWidth(i, arr[i]);
//		}
//
//		// 只导出有别名的字段
//		excelWriter.setOnlyAlias(true);
//		// 一次性写出内容，使用默认样式，强制输出标题
//		excelWriter.write(invDetails, true);
//		// 从第几行写入
////        excelWriter.setCurrentRow(1);
////        excelWriter.writeRow(data());
//		// 设置某个单元格的样式
////        CellStyle orCreateCellStyle = excelWriter.getOrCreateCellStyle(0, 1);
//		// 设置某行的样式
////        excelWriter.setRowStyle();
//
//		try {
//			String fileName = URLEncoder.encode("invId", StandardCharsets.UTF_8.name());
//			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//			response.setCharacterEncoding("utf-8");
//			response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//			// 将Excel Workbook刷出到输出流
//			excelWriter.flush(response.getOutputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw new RuntimeException("文件写入失败！");
//		}
//		//关闭流
//		excelWriter.close();
//	}
}
