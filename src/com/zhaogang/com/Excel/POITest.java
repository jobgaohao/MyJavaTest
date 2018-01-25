package com.zhaogang.com.Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POITest {

	public static void main(String[] args) {
		try {
			createExcel();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public static void createExcel() throws Exception{
		String[] title={"id","name","sex"};
		//创建Excel 工作簿
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=null;
		for (int i = 0; i < title.length; i++) {
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for (int i = 1; i < 10; i++) {
			HSSFRow nextrow=sheet.createRow(i);
			HSSFCell cell2=nextrow.createCell(0);
			cell2.setCellValue("a"+i);
			cell2=nextrow.createCell(1);
			cell2.setCellValue("张三"+i);
			cell2=nextrow.createCell(2);
			cell2.setCellValue("男");
			
		}
		//创建文件
		File file=new File("d:/poi_test.xls");
		OutputStream outStream=new FileOutputStream(file);
		workbook.write(outStream);
		outStream.close();
	}
}
