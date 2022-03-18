package com.sale.att;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public String readpropertieData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IAutoConstants.pro_path);
		Properties pro=new Properties();
		pro.load(fis);
		
		return pro.getProperty(key, "inccorect key");
	}
	
	public void writeExcelData( String sheet, int row, int cell, String value) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(IAutoConstants.ex_path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		
	FileOutputStream fos = new FileOutputStream(IAutoConstants.ex_path);	
		wb.write(fos);
	}

}
