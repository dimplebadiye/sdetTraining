package com.utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadTestDataFile {

	static String path = "/Cucumber_Selenium/res/testdata/TestData.xlsx";
	static String sheetName = "Sheet1";

	public void readExcel() throws IOException {
		 FileInputStream inputStream = new FileInputStream(path);

		 Workbook wb = new XSSFWorkbook(inputStream);
		 
		 Sheet sheet = wb.getSheet(sheetName);

		 int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		 for (int i = 0; i < rowCount+1; i++) {
			 Row row = sheet.getRow(i);
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        }
		 }
	}
		
}