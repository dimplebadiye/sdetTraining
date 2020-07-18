package com.utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ReadTestDataFile {

	static String path = "C:\\Users\\DimpleBadiye\\Desktop\\SDET\\eclipse-workspace\\Cucumber_Selenium\\res\\testdata\\TestData.xlsx";
	static String sheetName = "Sheet1";

	public List<String> readExcel() throws IOException {
		
		List<String> testData = new ArrayList<String>();
		
		FileInputStream fs = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		
		XSSFSheet sh = wb.getSheet(sheetName);

	    int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();

	    for (int i = 1; i < rowCount + 1; i++) {
	    	Row row = sh.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            testData.add(row.getCell(j).getStringCellValue());
	        }
	    }
	    
	    return testData;
	}
}