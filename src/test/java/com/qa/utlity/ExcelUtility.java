package com.qa.utlity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	// Code with different static methods that can help to reach the data from an excel file.
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook xBook;
	public static XSSFSheet xSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	// method will fetch the rowcount from the specific sheet of an excel workbook
	
	public static int getRowCount(String xFile,String xSheetName) throws IOException {		
		fileLoc = new FileInputStream(xFile);
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);
		int rowCount = xSheet.getLastRowNum();		
		return rowCount;
	}
	
	// method will fetch the cellCount of each row  from the specific sheet of an excel workbook

	public static int getCellCount(String xFile,String xSheetName, int rowNum) throws IOException {
		fileLoc = new FileInputStream(xFile);
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	// Method to read the data from each cell in a string format of a row from the specifi sheet of an excel workkbook
	
	public static String getCellData(String xFile,String xSheetName, int rowNum, int cellNum) throws IOException {
		fileLoc = new FileInputStream(xFile);
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String cellData = format.formatCellValue(cell);
		
		fileLoc.close();
		xBook.close();
		
		return cellData;
	}

}
