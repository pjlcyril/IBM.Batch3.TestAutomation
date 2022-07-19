package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utlity.ExcelUtility;

public class TC_Amazon_001 extends TestBase {

	//public static void main(String[] args) throws InterruptedException {
	
	@Test(dataProvider="getData") 
	public void searchItem(String Category, String ItemName) throws InterruptedException, IOException {
		
		boolean contains = driver.getTitle().contains("Amazon");
		if(contains) {
			sAssert.assertTrue(contains);
			Reporter.log("The user is on amazon page",true);
		}else {
			capturescreenshot(driver,"searchItem");
			sAssert.assertTrue(contains);
			Reporter.log("The user is not on amazon page",true);
		}
		
		AmazonOR.getCategory().selectByVisibleText(Category); // 1st field
		AmazonOR.getSearchTextField().clear();
		AmazonOR.getSearchTextField().sendKeys(ItemName); // 2nd field
		AmazonOR.getMagnifierBtn().click();		
		//Thread.sleep(3000);
		
		expWait.until(ExpectedConditions.titleContains(ItemName));
		
		
		boolean contains1 = driver.getTitle().contains(ItemName);
		
		if(contains1) {
			sAssert.assertTrue(contains1);
			Reporter.log("The title is same as item name",true);
		}else {
			capturescreenshot(driver,"searchItem");
			sAssert.assertTrue(contains1);
			Reporter.log("The title is not same as item name",true);
		}
		
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println("Total no. of items loaded are : " + allItems.size());
		
		for(WebElement item: allItems) {
			Reporter.log(item.getText(),true);
		}
		
		sAssert.assertAll();
	}
	// The method below this annotation will be sourcing the String inputs to the another method with in the class anntotated as @Test
	// returns only Object[][]
	
	@DataProvider
	public String[][] getData() throws IOException{
		
		String xFile = "D:\\Selenium Training\\HyDigit - Batch 3 - FY'23\\IBM.Batch3.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName = "Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName); // total no. of values to each field
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount); // total no. of fields
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		
		
		return data;
		
	//	Object[][] data = new Object[Rowsize][CellSize]; // RowSize and CellSize should be fetched from the xSheet location
		
		/*
		
		Object[][] data = new Object[3][2];
		
		//Category
		data[0][0] = "Books";
		data[1][0] = "Electronics";
		data[2][0] = "Furniture";
		
		// Item Name
		data[0][1] = "Da vinci code";
		data[1][1] = "Mobile phones";
		data[2][1] = "Wooden table";
		
		return data;*/
	}
	
	

}
