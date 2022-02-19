package com.test.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.constant.SourcePath;

public class ExcelUtlis {
	public void getRowCount()  {
		String xlpath=SourcePath.XLPATH;
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(xlpath);
			XSSFSheet sheet=workbook.getSheet("sheet1");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getCellCount() {
		String xlpath=SourcePath.XLPATH;
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(xlpath);
		
		XSSFSheet sheet=workbook.getSheet("sheet1");
		DataFormatter formater=new DataFormatter();
		Object value=formater.formatCellValue(sheet.getRow(1).getCell(2));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
