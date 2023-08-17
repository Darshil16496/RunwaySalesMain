package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.Multiset.Entry;

public class ExcelUtility {
	public String readDatafromExcel(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		//DataFormatter df = new DataFormatter();
		String value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);;
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		wb.write(fos);
		wb.close();
	}
	
	public int getLastRow(String sheetName) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getLastRowNum();
		return row;
	}

	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyCellNo, int valueCellNo, WebDriver cd) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i = 0 ; i <= row ; i++) {
			String key = sh.getRow(i).getCell(keyCellNo).getStringCellValue();
			String Value = sh.getRow(i).getCell(valueCellNo).getStringCellValue();
			map.put(key, Value);
		}
		
		for(java.util.Map.Entry<String, String> set:map.entrySet()) {
			cd.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		return map;
	}
	
	public Object[][] getDataFromExcelSheet(String SheetName) throws Throwable{
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook book= WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		
		
		Object[][] obj = null;
		for (int i = 0; i < lastRow; i++) {
			short lastCell = sh.getRow(i).getLastCellNum();
			obj = new Object[lastRow+1][lastCell];
			for (int j = 0; j < lastCell; j++) {
					System.out.println("I ="+i+"J ="+j);
					obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
	}
}
	
