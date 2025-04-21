package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D12CreateFriendsData {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void writeFriendsData() {
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Tejavathi");
		
		//row = sheet.createRow(0);
		cell = row.createCell(1);
		cell.setCellValue("T");
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Anusha");
		
		cell = row.createCell(1);
		cell.setCellValue("K");
		
		sheet.createRow(2).createCell(0).setCellValue("Vidya");
		sheet.getRow(2).createCell(1).setCellValue("Kulkarni");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File("ExcelFiles\\FriendsData.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Friends Data");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
